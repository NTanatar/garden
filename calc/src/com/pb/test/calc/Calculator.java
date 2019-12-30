package com.pb.test.calc;

import com.pb.test.math.OperationNotFoundException;

public class Calculator {
    private OperationFactory opFactory;

    public Calculator(OperationFactory opFactory) {
        this.opFactory = opFactory;
    }

    public void exec() throws OperationNotFoundException {
        String input = takeInput("hi! enter the first number or <enter> for quit:");

        while (!input.isEmpty()) {
            double firstOperand = Double.parseDouble(input);

            input = takeInput("enter the operator:");
            Operation operation = opFactory.getOpInstance(input);

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

    public static void main(String[] args) {
        OperationFactory myFactory = new MyOpFactory();
        Calculator jim = new Calculator(myFactory);
        try {
            jim.exec();
        } catch (NumberFormatException e) {
            System.err.println("This was not a number! Bye!");
        } catch (OperationNotFoundException e) {
            System.out.println("Invalid operator (expected: +, -, *, /). Bye!");
        }
    }
}

