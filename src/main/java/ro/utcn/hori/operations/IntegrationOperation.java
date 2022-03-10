package ro.utcn.hori.operations;

import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IntegrationOperation implements UnaryOperation{

    public Polynomial perform(Polynomial a) {
        List<Monomial> monomials = a.getMonomials();
        Map<Integer, Float> acc = new LinkedHashMap<>();
        for(Monomial mon: monomials) {
            if(acc.containsKey(mon.getExp() + 1)) {
                acc.put(mon.getExp() + 1, acc.get(mon.getExp() + 1) + mon.getCoefficient()/( mon.getExp() + 1 ));
            } else {
                acc.put(mon.getExp() + 1, mon.getCoefficient()/( mon.getExp() + 1));
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
