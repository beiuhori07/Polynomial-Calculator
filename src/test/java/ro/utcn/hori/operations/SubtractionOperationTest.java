package ro.utcn.hori.operations;

import org.junit.Test;
import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SubtractionOperationTest {
    @Test
    public void perform() {
        Polynomial a = new Polynomial(Arrays.asList(new Monomial(3, 2)));
        Polynomial b = new Polynomial(Arrays.asList(new Monomial(1, 1)));
        Monomial[] monomials = new Monomial[] { new Monomial(3, 2), new Monomial(-1, 1)};
        Polynomial expected = new Polynomial(Arrays.asList(monomials));

        BinaryOperation diff = new SubtractionOperation();
        Polynomial actual = diff.perform(a, b);

        System.out.println(expected.toString());
        System.out.println(actual.toString());

        assertEquals(expected, actual);
    }
    @Test
    public void sub1() {
        Polynomial a = new Polynomial("3x^7 + 12x^2 - 11x + 1");
        Polynomial b = new Polynomial("2x^7 + 1x^2 - 8");
        Polynomial expected = new Polynomial("x^7 + 11x^2 - 11x + 9");
        BinaryOperation sub = new SubtractionOperation();
        Polynomial actual = sub.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void sub2() {
        Polynomial a = new Polynomial("4x^7 - 11x^5 + 22x^4 + 1");
        Polynomial b = new Polynomial("- 2x^3 + 1x^2 - 8");
        Polynomial expected = new Polynomial("4x^7 - 11x^5 + 22x^4 + 2x^3 - 1x^2 + 9");
        BinaryOperation sub = new SubtractionOperation();
        Polynomial actual = sub.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void sub3() {
        Polynomial a = new Polynomial("4x^7 - 11x^5 + 22x^4 + 1");
        Polynomial b = new Polynomial("4x^7 - 11x^5 + 22x^4 + 1");
        Polynomial expected = new Polynomial("");
        BinaryOperation sub = new SubtractionOperation();
        Polynomial actual = sub.perform(a, b);
        assertEquals(expected, actual);
    }
    @Test
    public void sub4() {
        Polynomial a = new Polynomial("0x^7 - 0x^5 + 0x^4 + 0");
        Polynomial b = new Polynomial("0x^7 - 0x^5 + 0x^4 + 0");
        Polynomial expected = new Polynomial("");
        BinaryOperation sub = new SubtractionOperation();
        Polynomial actual = sub.perform(a, b);
        assertEquals(expected, actual);
    }
}
