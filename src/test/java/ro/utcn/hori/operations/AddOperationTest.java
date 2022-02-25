package ro.utcn.hori.operations;

import org.junit.Test;
import ro.utcn.hori.model.Monomial;
import ro.utcn.hori.model.Polynomial;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AddOperationTest {
    @Test
    void perform() {
        Polynomial a = new Polynomial(Arrays.asList(new Monomial(1, 1)));
        Polynomial b = new Polynomial(Arrays.asList(new Monomial(2, 1)));
        Polynomial expected = new Polynomial(Arrays.asList(new Monomial(2, 1)));


        BinaryOperation add = new AddOperation();
        Polynomial actual = add.perform(a, b);

        assertEquals(expected, actual);
    }
}
