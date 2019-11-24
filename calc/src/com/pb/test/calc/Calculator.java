package com.pb.test.calc;

import java.security.InvalidParameterException;

public class Calculator {
    private OperationFactory opFactory;

    Calculator(OperationFactory opFactory) {
        this.opFactory = opFactory;
    }

    public void exec() {
        String input = takeInput("hi! enter the first number or <enter> for quit:");

        while (!input.isEmpty()) {
            double firstOperand = Double.parseDouble(input);

            input = takeInput("enter the operator:");
            Operation operation = opFactory.getOpInstance(input);
            if (operation == null) {
                throw new InvalidParameterException();
            }
            input = takeInput("enter the second number:");
            double secondOperand = Double.parseDouble(input);

            double result = operation.exec(firstOperand, secondOperand);
            System.out.println(" = " + result);

            input = takeInput("enter the first number or <enter> for quit:");
        }
    }

    private static String takeInput(String message) {
        System.out.println(message);
        return System.console().readLine();
    }

    /**
     * do simple operation over two operands
     *
     * @param operator operator like + - * /
     * @param a        first operand
     * @param b        second operand
     * @return result of the specified operation
     */
    private static int doCalculation(char operator, int a, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new InvalidParameterException("invalid operator! expected: +, -, *, /");
        }
    }

    public static void main(String[] args) {
        OperationFactory myFactory = new MyOpFactory();
        Calculator jim = new Calculator(myFactory);
        try {
            jim.exec();
        } catch (NumberFormatException e) {
            System.err.println("This was not a number! Bye!");
        } catch (InvalidParameterException e) {
            System.out.println("invalid operator! expected: +, -, *, /  Bye!");
        }
    }
}

class OpPlus implements Operation {
    @Override
    public double exec(double a, double b) {
        return a + b;
    }
}

class OpMinus implements Operation {
    @Override
    public double exec(double a, double b) {
        return a - b;
    }
}

class OpMul implements Operation {
    @Override
    public double exec(double a, double b) {
        return a * b;
    }
}

class OpDiv implements Operation {
    @Override
    public double exec(double a, double b) {
        return a / b;
    }
}

class MyOpFactory implements OperationFactory {

    @Override
    public Operation getOpInstance(String op) {
        switch (op) {
            case "+":
                return new OpPlus();
            case "-":
                return new OpMinus();
            case "*":
                return new OpMul();
            case "/":
                return new OpDiv();
        }
        return null;
    }
}

