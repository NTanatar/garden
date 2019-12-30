package com.pb.test.calc.operation;

import com.pb.test.calc.Operation;

public class OpMinus implements Operation {
    @Override
    public double exec(double a, double b) {
        return a - b;
    }
}
