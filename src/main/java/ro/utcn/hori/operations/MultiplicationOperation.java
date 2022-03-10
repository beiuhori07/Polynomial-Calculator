package ro.utcn.hori.operations;

import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MultiplicationOperation implements  BinaryOperation{

    public Polynomial perform(Polynomial a, Polynomial b) {
        Map<Integer, Float> acc = new LinkedHashMap<>();
        List<Monomial> aMonos = a.getMonomials();
        List<Monomial> bMonos = b.getMonomials();

        for(Monomial mon1: aMonos) {
            for(Monomial mon2: bMonos) {

                int expSum = mon1.getExp() + mon2.getExp();
                if(acc.containsKey(expSum)) {
                    acc.put( expSum, acc.get(expSum) + mon1.getCoefficient() * mon2.getCoefficient());
                } else {
                    acc.put( expSum, mon1.getCoefficient() * mon2.getCoefficient());
                }

            }
        }

        List<Monomial> resultList = new ArrayList<>();
        acc.forEach( (exp, coefficient) -> {
            if(coefficient != 0) {
                resultList.add(new Monomial(coefficient, exp));
            }
        });

        return new Polynomial(resultList);
    }
}
