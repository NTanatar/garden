package com.pb.test.calc;

import com.pb.test.tools.Important;

import java.security.InvalidParameterException;

public class SimpleCalculator {

    public SimpleCalculator() {
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
}
