package com.pb.test.calc;

import com.pb.test.math.OperationNotFoundException;
import com.pb.test.tools.Important;

import java.security.InvalidParameterException;

public class Calculator {
    private OperationFactory opFactory;

    public Calculator(OperationFactory opFactory) {
        this.opFactory = opFactory;
    }

    public Calculator() {
        this(new MyOpFactory());
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

    /**
     * do simple operation over two operands
     *
     * @param operator operator like + - * /
     * @param a        first operand
     * @param b        second operand
     * @return result of the specified operation
     */
    private static int doCalculation(@Important char operator, @Important int a, @Important int b) {
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
        } catch (OperationNotFoundException e) {
            System.out.println("Invalid operator (expected: +, -, *, /). Bye!");
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
    public Operation getOpInstance(String op) throws OperationNotFoundException {
        switch (op) {
            case "+":
                return new OpPlus();
            case "-":
                return new OpMinus();
            case "*":
                return new OpMul();
            case "/":
                return new OpDiv();
            default:
                throw new OperationNotFoundException();
        }
    }
}

