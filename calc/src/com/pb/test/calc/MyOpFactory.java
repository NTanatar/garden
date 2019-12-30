package com.pb.test.calc;

import com.pb.test.calc.operation.OpDiv;
import com.pb.test.calc.operation.OpMinus;
import com.pb.test.calc.operation.OpMul;
import com.pb.test.calc.operation.OpPlus;
import com.pb.test.math.OperationNotFoundException;

import java.util.HashMap;

public class MyOpFactory implements OperationFactory {

    private HashMap<String, Operation> operations = new HashMap<String, Operation>();

    @Override
    public Operation getOpInstance(String id) throws OperationNotFoundException {
        if (operations.containsKey(id)) {
            System.out.println("found in cache: " + id);
            return operations.get(id);
        }
        Operation op;
        switch (id) {
            case "+":
                op = new OpPlus();
                break;
            case "-":
                op = new OpMinus();
                break;
            case "*":
                op = new OpMul();
                break;
            case "/":
                op = new OpDiv();
                break;
            default:
                throw new OperationNotFoundException();
        }
        System.out.println("created: " + id);
        operations.put(id, op);
        return op;
    }
}