package ro.utcn.hori.operations;

import ro.utcn.hori.model.Polynomial;

public interface BinaryOperation {
    Polynomial perform(Polynomial a, Polynomial b);
}
