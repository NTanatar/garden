package com.pb.test.calc;

public interface OperationFactory {
    Operation getOpInstance(String op);
}
