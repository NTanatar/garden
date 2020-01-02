package com.pb.test.calc;

import com.pb.test.calc.operation.OpDiv;
import com.pb.test.calc.operation.OpMinus;
import com.pb.test.calc.operation.OpMul;
import com.pb.test.calc.operation.OpPlus;
import com.pb.test.math.OperationNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class MyOpFactory implements OperationFactory {

    private static Map<String, Operation> operations;

    static {
        operations = new HashMap<>();
        operations.put("+", new OpPlus());
        operations.put("-", new OpMinus());
        operations.put("*", new OpMul());
        operations.put("/", new OpDiv());
    }

    @Override
    public Operation getOpInstance(String id) throws OperationNotFoundException {
        if (operations.containsKey(id)) {
            return operations.get(id);
        } else {
            throw new OperationNotFoundException();
        }
    }
}