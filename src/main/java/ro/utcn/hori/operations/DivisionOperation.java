package ro.utcn.hori.operations;

import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisionOperation implements BinaryOperation {

    public Polynomial perform(Polynomial a, Polynomial b) throws ArithmeticException {
        List<Monomial> dividendMonos = a.getMonomials();
        List<Monomial> divisorMonos = b.getMonomials();
        if(divisorMonos.size() == 1 && divisorMonos.get(0).getCoefficient() == 0)
            throw new ArithmeticException("Division by zero");
        List<Monomial> quotientMonos = new ArrayList<>();

        BinaryOperation addOp = new AddOperation();
        BinaryOperation diffOp = new SubtractionOperation();
        BinaryOperation multiplyOp = new MultiplicationOperation();

        while(dividendMonos.size() != 0 && dividendMonos.get(0).getExp() >= divisorMonos.get(0).getExp()) {
            Monomial temp = new Monomial(dividendMonos.get(0).getCoefficient()/divisorMonos.get(0).getCoefficient(), dividendMonos.get(0).getExp() - divisorMonos.get(0).getExp());
            Polynomial tempPoly = new Polynomial(Arrays.asList(temp)); //!!!
            quotientMonos.add(temp);

            Polynomial tempPoly2 = multiplyOp.perform(b, tempPoly);
            a = diffOp.perform(a, tempPoly2);

            dividendMonos = a.getMonomials();
            divisorMonos = b.getMonomials();

        }

        return new Polynomial(quotientMonos);
    }
}
