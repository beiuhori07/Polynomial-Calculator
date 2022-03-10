package ro.utcn.hori.operations;

import org.junit.Test;
import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AddOperationTest {
    @Test
    public void perform() {
        Polynomial a = new Polynomial(Arrays.asList(new Monomial(1, 1)));
        Polynomial b = new Polynomial(Arrays.asList(new Monomial(2, 2)));
        Monomial[] monomials = new Monomial[] {new Monomial(2, 2), new Monomial(1, 1)};
        Polynomial expected = new Polynomial(Arrays.asList(monomials));
        BinaryOperation add = new AddOperation();
        Polynomial actual = add.perform(a, b);

        assertEquals(expected, actual);
    }


    @Test
    public void add1() {
        Polynomial a = new Polynomial("1x^2+1x^3");
        Polynomial b = new Polynomial("3x^2");
        Polynomial expected = new Polynomial("1x^3+4x^2");
        BinaryOperation add = new AddOperation();
        Polynomial actual = add.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void add2() {
        Polynomial a = new Polynomial("5x^1+17x^4 + 2x^1 - x^2 + 2 + 3x");
        Polynomial b = new Polynomial("-3x^2 - x");
        Polynomial expected = new Polynomial("17x^4 - 4x^2 + 9x + 2");
        BinaryOperation add = new AddOperation();
        Polynomial actual = add.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void add3() {
        Polynomial a = new Polynomial("-x - x -2x + 5 -   6 -1 + 2");
        Polynomial b = new Polynomial("-3x^2 - x^1 - 5x^0");
        Polynomial expected = new Polynomial("-3x^2 - 5x - 5");
        BinaryOperation add = new AddOperation();
        Polynomial actual = add.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void add4() {
        Polynomial a = new Polynomial("x^5 + x^4 + x^3");
        Polynomial b = new Polynomial("-x^5 - x^4 - x^3");
        Polynomial expected = new Polynomial("");
        BinaryOperation add = new AddOperation();
        Polynomial actual = add.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void add5() {
        Polynomial a = new Polynomial("0x^5 + 0x^4");
        Polynomial b = new Polynomial("-0x^5 - 0x^4 - 0x^3");
        Polynomial expected = new Polynomial("");
        BinaryOperation add = new AddOperation();
        Polynomial actual = add.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void add6() {
        Polynomial a = new Polynomial("-100 + 100 - 50");
        Polynomial b = new Polynomial("0");
        Polynomial expected = new Polynomial("-50");
        BinaryOperation add = new AddOperation();
        Polynomial actual = add.perform(a, b);
        assertEquals(expected, actual);
    }
}
