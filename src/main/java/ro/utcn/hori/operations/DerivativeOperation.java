package ro.utcn.hori.operations;

import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DerivativeOperation implements UnaryOperation{

    public Polynomial perform(Polynomial a) {
        Map<Integer, Float> acc = new LinkedHashMap<>();
        List<Monomial> monomials = a.getMonomials();
        for(Monomial mon: monomials) {
            if(mon.getExp() != 0) {
                if(acc.containsKey(mon.getExp() - 1)) {
                    acc.put(mon.getExp() - 1, acc.get(mon.getExp() - 1) + mon.getCoefficient() * mon.getExp());
                } else {
                    acc.put(mon.getExp() - 1, mon.getCoefficient() * mon.getExp());
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
