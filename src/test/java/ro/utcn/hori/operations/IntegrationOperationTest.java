package ro.utcn.hori.operations;

import org.junit.Test;
import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IntegrationOperationTest {
    @Test
    public void perform() {
        Monomial[] monomials = new Monomial[] { new Monomial(8, 4), new Monomial(12, 1), new Monomial(-4, 3), new Monomial(-6, 0) };
        Polynomial a = new Polynomial(Arrays.asList(monomials));

        Monomial[] monomials1 = new Monomial[] { new Monomial(8/5f, 5), new Monomial(6, 2), new Monomial(-1, 4), new Monomial(-6, 1)};
        Polynomial expected = new Polynomial(Arrays.asList(monomials1));

        UnaryOperation integration = new IntegrationOperation();
        Polynomial actual = integration.perform(a);

        System.out.println(expected.toString());
        System.out.println(actual.toString());

        assertEquals(expected, actual);
    }
    @Test
    public void integration1() {
        Polynomial a = new Polynomial("4x^3 + x^4 + 6x^2");
        Polynomial expected = new Polynomial("x^4 + 0.2x^5 + 2x^3");
        UnaryOperation integration = new IntegrationOperation();
        Polynomial actual = integration.perform(a);
        assertEquals(expected, actual);
    }
    @Test
    public void integration2() {
        Polynomial a = new Polynomial("12x^11 + 24x");
        Polynomial expected = new Polynomial("x^12 + 12x^2");
        UnaryOperation integration = new IntegrationOperation();
        Polynomial actual = integration.perform(a);
        assertEquals(expected, actual);
    }
    @Test
    public void integration3() {
        Polynomial a = new Polynomial("2x^4 + 4x^4");
        Polynomial expected = new Polynomial("1.2x^5");
        UnaryOperation integration = new IntegrationOperation();
        Polynomial actual = integration.perform(a);
        assertEquals(expected, actual);
    }
}
