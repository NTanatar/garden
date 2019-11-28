package com.pb.test.calc;

import com.pb.test.math.OperationNotFoundException;

public interface OperationFactory {
    Operation getOpInstance(String op) throws OperationNotFoundException;
}
