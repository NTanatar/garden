package com.pb.test.calc;

import com.pb.test.math.OperationNotFoundException;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {
    private OperationFactory opFactory;

    public Calculator(OperationFactory opFactory) {
        this.opFactory = opFactory;
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
            double firstOperand = Double.parseDouble(t.nextToken());
            Operation operation = opFactory.getOpInstance(t.nextToken());
            double secondOperand = Double.parseDouble(t.nextToken());

            double result = operation.exec(firstOperand, secondOperand);
            System.out.println(" = " + result);

            input = getInput(scanner, "enter <arg1> <operator> <arg2> or <enter> for quit:");
        }
    }

    public static void main(String[] args) {
        OperationFactory myFactory = new MyOpFactory();
        Calculator jim = new Calculator(myFactory);
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

