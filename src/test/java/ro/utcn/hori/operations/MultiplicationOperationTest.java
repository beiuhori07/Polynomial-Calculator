package ro.utcn.hori.operations;

import org.junit.Test;
import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MultiplicationOperationTest {

    @Test
    public void perform() {
        Monomial[] monomialsA = new Monomial[]  { new Monomial(3, 1), new Monomial(1, 1), new Monomial(-2, 0)};
        Polynomial a = new Polynomial(Arrays.asList(monomialsA));

        Monomial[] monomialsB = new Monomial[]  { new Monomial(2, 3), new Monomial(3, 0)};
        Polynomial b = new Polynomial(Arrays.asList(monomialsB));

        Monomial[] monomials = new Monomial[] { new Monomial(8, 4), new Monomial(12, 1), new Monomial(-4, 3), new Monomial(-6, 0) };
        Polynomial expected = new Polynomial(Arrays.asList(monomials));

        BinaryOperation multiplication = new MultiplicationOperation();
        Polynomial actual = multiplication.perform(a, b);

        System.out.println(expected.toString());
        System.out.println(actual.toString());

        assertEquals(expected, actual);
    }
    @Test
    public void multiply1() {
        Polynomial a = new Polynomial("x^2 + 2");
        Polynomial b = new Polynomial("-x^3 + x");
        Polynomial expected = new Polynomial("- x^5 -x^3 + 2x");
        BinaryOperation multiply = new MultiplicationOperation();
        Polynomial actual = multiply.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void multiply2() {
        Polynomial a = new Polynomial("x^2 + 2x^2");
        Polynomial b = new Polynomial("x + 3");
        Polynomial expected = new Polynomial("3x^3 + 9x^2");
        BinaryOperation multiply = new MultiplicationOperation();
        Polynomial actual = multiply.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void multiply3() {
        Polynomial a = new Polynomial("x^2 + 2x^2");
        Polynomial b = new Polynomial("x + 0");
        Polynomial expected = new Polynomial("3x^3");
        BinaryOperation multiply = new MultiplicationOperation();
        Polynomial actual = multiply.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void multiply4() {
        Polynomial a = new Polynomial("x^2 + 0x^2 + 3x - 4");
        Polynomial b = new Polynomial("x + 0");
        Polynomial expected = new Polynomial("x^3 + 3x^2 -4x");
        BinaryOperation multiply = new MultiplicationOperation();
        Polynomial actual = multiply.perform(a, b);
        assertEquals(expected, actual);
    }
}
