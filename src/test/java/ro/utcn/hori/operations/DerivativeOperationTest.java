package ro.utcn.hori.operations;

import org.junit.Test;
import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DerivativeOperationTest {

    @Test
    public void perform() {
        Monomial[] monomials = new Monomial[] { new Monomial(8, 4), new Monomial(12, 1), new Monomial(-4, 3), new Monomial(-6, 0) };
        Polynomial a = new Polynomial(Arrays.asList(monomials));

        Monomial[] monomials1 = new Monomial[] { new Monomial(32, 3), new Monomial(12, 0), new Monomial(-12, 2)};
        Polynomial expected = new Polynomial(Arrays.asList(monomials1));

        UnaryOperation derivative = new DerivativeOperation();
        Polynomial actual = derivative.perform(a);

        System.out.println(expected.toString());
        System.out.println(actual.toString());

        assertEquals(expected, actual);
    }
    @Test
    public void derivative1() {
        Polynomial a = new Polynomial("4x^3 + 10x^2");
        Polynomial expected = new Polynomial("12x^2 + 20x^1");
        UnaryOperation derivative = new DerivativeOperation();
        Polynomial actual = derivative.perform(a);
        assertEquals(expected, actual);
    }
    @Test
    public void derivative2() {
        Polynomial a = new Polynomial("-2x^7 - 10x + 100");
        Polynomial expected = new Polynomial("-14x^6 - 10");
        UnaryOperation derivative = new DerivativeOperation();
        Polynomial actual = derivative.perform(a);
        assertEquals(expected, actual);
    }
    @Test
    public void derivative3() {
        Polynomial a = new Polynomial("100 + 100 -50");
        Polynomial expected = new Polynomial("");
        UnaryOperation derivative = new DerivativeOperation();
        Polynomial actual = derivative.perform(a);
        assertEquals(expected, actual);
    }
    @Test
    public void derivative4() {
        Polynomial a = new Polynomial("0.5x^4 + 0.33x");
        Polynomial expected = new Polynomial("2x^3 + 0.33");
        UnaryOperation derivative = new DerivativeOperation();
        Polynomial actual = derivative.perform(a);
        assertEquals(expected, actual);
    }
}
