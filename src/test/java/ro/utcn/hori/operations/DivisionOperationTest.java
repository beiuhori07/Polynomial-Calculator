package ro.utcn.hori.operations;

import org.junit.Test;
import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DivisionOperationTest {
    @Test
    public void perform() {
        Monomial[] monomialsA = new Monomial[]  { new Monomial(1, 3), new Monomial(-2, 2), new Monomial(6, 1), new Monomial(5, 0)};
        Polynomial a = new Polynomial(Arrays.asList(monomialsA));

        Monomial[] monomialsB = new Monomial[]  { new Monomial(1, 2), new Monomial(1, 0)};
        Polynomial b = new Polynomial(Arrays.asList(monomialsB));

        Monomial[] monomials = new Monomial[] { new Monomial(1, 1), new Monomial(-2, 0) };
        Polynomial expected = new Polynomial(Arrays.asList(monomials));


        BinaryOperation div = new DivisionOperation();
        Polynomial actual = div.perform(a, b);

        assertEquals(expected, actual);
    }
    @Test
    public void division1() {
        Polynomial a = new Polynomial("x^3");
        Polynomial b = new Polynomial("x");
        Polynomial expected = new Polynomial("x^2");
        BinaryOperation division = new DivisionOperation();
        Polynomial actual = division.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void division2() {
        Polynomial a = new Polynomial("x^3 - 27");
        Polynomial b = new Polynomial("x - 3");
        Polynomial expected = new Polynomial("x^2 + 3x + 9");
        BinaryOperation division = new DivisionOperation();
        Polynomial actual = division.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void division3() {
        Polynomial a = new Polynomial("3x^2 + 5x + 2");
        Polynomial b = new Polynomial("2x + 1");
        Polynomial expected = new Polynomial("1.5x^1 + 1.75");
        BinaryOperation division = new DivisionOperation();
        Polynomial actual = division.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void division4() {
        Polynomial a = new Polynomial("4x^5 + 11x^3 + x^2 + 12");
        Polynomial b = new Polynomial("2x^2 + x");
        Polynomial expected = new Polynomial("2x^3 - x^2 + 6x - 2.5");
        BinaryOperation division = new DivisionOperation();
        Polynomial actual = division.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void division5() {
        Polynomial a = new Polynomial("4x^2 + 12x + 9");
        Polynomial b = new Polynomial("2x + 3");
        Polynomial expected = new Polynomial("2x + 3");
        BinaryOperation division = new DivisionOperation();
        Polynomial actual = division.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void division6() {
        Polynomial a = new Polynomial("9x^2 - 18x + 9");
        Polynomial b = new Polynomial("3x - 3");
        Polynomial expected = new Polynomial("3x - 3");
        BinaryOperation division = new DivisionOperation();
        Polynomial actual = division.perform(a, b);
        assertEquals(expected, actual);
    }
}
