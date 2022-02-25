package ro.utcn.hori.operations;

import ro.utcn.hori.model.Polynomial;

public interface UnaryOperation {
    Polynomial perform(Polynomial a);
}
