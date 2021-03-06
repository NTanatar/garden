package com.pb.test.calc;

import com.pb.test.math.OperationNotFoundException;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Properties;

public class Calculator {
    private static String LOG_ENTRY_FORMAT = "logEntryFormat";
    private static String LOG_ENTRY_KEY = "logEntryKey";
    private static String LOG_ENTRY_COMMENT = "logEntryComment";
    private static String DEFAULT_LOG_ENTRY_FORMAT = "*** %f %s %f is %f (ok)";
    private static String DEFAULT_LOG_ENTRY_KEY = "op";
    private static String DEFAULT_LOG_COMMENT = "K";

    private OperationFactory opFactory;
    private Properties settings;
    private Properties operationsLog;
    private OutputStream outStream;

    public Calculator(OperationFactory opFactory, String settingsFile, String outputFile) {
        this.opFactory = opFactory;
        initSettings(settingsFile);
        initLogging(outputFile);
    }

    private void initSettings(String fileName) {
        this.settings = new Properties();
        try {
            settings.loadFromXML(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + "not found, using default settings");
            setDefaultSettings(fileName);
        } catch (Exception e) {
            System.out.println("Error on loading xml, using default settings");
            setDefaultSettings(fileName);
        }
    }

    private void setDefaultSettings(String outputFile) {
        settings.setProperty(LOG_ENTRY_FORMAT, DEFAULT_LOG_ENTRY_FORMAT);
        settings.setProperty(LOG_ENTRY_KEY, DEFAULT_LOG_ENTRY_KEY);
        settings.setProperty(LOG_ENTRY_COMMENT, DEFAULT_LOG_COMMENT);

        if (outputFile != null && !outputFile.isEmpty()) {
            try {
                settings.storeToXML(new FileOutputStream(outputFile), "output format");
            } catch (Exception e) {
                System.out.println("error on storing default settings");
            }
        }
    }

    private void initLogging(String fileName) {
        this.operationsLog = new Properties();
        try {
            this.outStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + "not found, using stdout");
            this.outStream = System.out;
        }
    }

    public void executeReadingArgumentsOneByOne() throws OperationNotFoundException {
        String input = takeInputFromConsole("hi! enter the first number or <enter> for quit:");

        while (!input.isEmpty()) {
            double firstOperand = Double.parseDouble(input);

            input = takeInputFromConsole("enter the operator:");
            Operation operation = opFactory.getOpInstance(input);

            input = takeInputFromConsole("enter the second number:");
            double secondOperand = Double.parseDouble(input);

            double result = operation.exec(firstOperand, secondOperand);
            System.out.println(" = " + result);

            input = takeInputFromConsole("enter the first number or <enter> for quit:");
        }
    }

    private static String takeInputFromConsole(String message) {
        System.out.println(message);
        return System.console().readLine();
    }

    private static String getInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private void executeUsingTokenizer() throws OperationNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String input = getInput(scanner, "hi! enter <arg1> <operator> <arg2> or <enter> for quit:");

        while (!input.isEmpty()) {
            StringTokenizer t = new StringTokenizer(input, " ", false);
            if (t.countTokens() != 3) {
                throw new IllegalArgumentException("wrong number of arguments!");
            }
            double first = Double.parseDouble(t.nextToken());
            String op = t.nextToken();
            double second = Double.parseDouble(t.nextToken());
            double result = opFactory.getOpInstance(op).exec(first, second);

            System.out.println(" = " + result);
            storeOperationResult(String.format(settings.getProperty(LOG_ENTRY_FORMAT), first, op, second, result));

            input = getInput(scanner, "enter <arg1> <operator> <arg2> or <enter> for quit:");
        }
    }

    private void storeOperationResult(String formattedResult) {
        operationsLog.setProperty(settings.getProperty(LOG_ENTRY_KEY), formattedResult);
        try {
            operationsLog.store(outStream, settings.getProperty(LOG_ENTRY_COMMENT));
        } catch (IOException e) {
            System.out.println("something went wrong while storing result");
        }
    }

    public static void main(String[] args) {
        OperationFactory myFactory = new MyOpFactory();
        String outputFileName = "calculatorOutput" + System.currentTimeMillis() + ".txt";
        Calculator jim = new Calculator(myFactory, "settings.xml", outputFileName);
        try {
            jim.executeUsingTokenizer();
        } catch (NumberFormatException e) {
            System.err.println("This was not a number! Bye!");
        } catch (OperationNotFoundException e) {
            System.out.println("Invalid operator (expected: +, -, *, /). Bye!");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

