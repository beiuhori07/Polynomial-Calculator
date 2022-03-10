package ro.utcn.hori.operations;

import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.*;

public class AddOperation implements BinaryOperation{
    @Override
    public Polynomial perform(Polynomial a, Polynomial b) {
        Map<Integer , Float> acc = new LinkedHashMap<>();
        accumulate(acc, a);
        accumulate(acc, b);
        List<Monomial> monomials = new ArrayList<>();
        acc.forEach( (exp, coefficient) -> {
            if(coefficient != 0) {
                monomials.add(new Monomial(coefficient, exp));
            }
        });
        return new Polynomial(monomials);
    }

    private void accumulate(Map<Integer, Float> acc, Polynomial a) {
        for (Monomial monomial : a.getMonomials()) {
            if(acc.containsKey(monomial.getExp())) {
                acc.put(monomial.getExp(), acc.get(monomial.getExp()) + monomial.getCoefficient());
            } else {
                acc.put(monomial.getExp(), monomial.getCoefficient());
            }
        }
    }
}
