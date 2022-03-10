package ro.utcn.hori.operations;

import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SubtractionOperation implements BinaryOperation{
    public Polynomial perform(Polynomial a, Polynomial b) {
        Map<Integer, Float> acc = new LinkedHashMap<>();
        accumulateMinuend(acc, a);
        accumulateSubtrahend(acc, b);
        List<Monomial> monomials = new ArrayList<>();
        acc.forEach( (exp, coefficient) -> {
            if(coefficient != 0) {
                monomials.add(new Monomial(coefficient, exp));
            }
        });
        return new Polynomial(monomials);
    }

    private void accumulateMinuend(Map<Integer, Float> acc, Polynomial a) {
        for (Monomial monomial: a.getMonomials()) {
            acc.put(monomial.getExp(), monomial.getCoefficient());
        }
    }

    private void accumulateSubtrahend(Map<Integer, Float> acc, Polynomial a) {
        for (Monomial monomial: a.getMonomials()) {
            if(acc.containsKey(monomial.getExp())) {
                acc.put(monomial.getExp(), acc.get(monomial.getExp()) - monomial.getCoefficient());
            } else {
                acc.put(monomial.getExp(), (-1) * monomial.getCoefficient());
            }
        }
    }
}
