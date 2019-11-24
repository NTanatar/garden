package com.pb.test.calc;

import java.security.InvalidParameterException;

public class Calculator {

    public static void main(String[] args) {
        String input = takeInput("hi! enter the first number or <enter> for quit:");

        while (!input.isEmpty()) {
            int firstOperand = Integer.parseInt(input);

            input = takeInput("enter the operator:");
            char operator = input.charAt(0);

            input = takeInput("enter the second number:");
            int secondOperand = Integer.parseInt(input);

            int result = doCalculation(operator, firstOperand, secondOperand);
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
}

