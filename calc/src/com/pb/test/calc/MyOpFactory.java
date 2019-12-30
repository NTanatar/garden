package com.pb.test.calc;

import com.pb.test.calc.operation.OpDiv;
import com.pb.test.calc.operation.OpMinus;
import com.pb.test.calc.operation.OpMul;
import com.pb.test.calc.operation.OpPlus;
import com.pb.test.math.OperationNotFoundException;

public class MyOpFactory implements OperationFactory {

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