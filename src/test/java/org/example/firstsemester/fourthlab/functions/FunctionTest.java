package org.example.firstsemester.fourthlab.functions;

import org.example.firstsemester.fourthlab.functions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {

    @Test
    public void testLinearFunction() {
        IFunction linearFunction = new LinearFunction(2, 3, -1, 1);
        assertEquals(4.0, linearFunction.calculate(0.5), 0.0001);
        assertEquals(-1.0, linearFunction.getLowerBound(), 0.0001);
        assertEquals(1.0, linearFunction.getUpperBound(), 0.0001);
    }

    @Test
    public void testSinusFunction() {
        IFunction sineFunction = new SinusFunction(1, Math.PI, 0, 2 * Math.PI);
        assertEquals(1.0, sineFunction.calculate(0.5), 0.0001);
        assertEquals(0.0, sineFunction.getLowerBound(), 0.0001);
        assertEquals(2 * Math.PI, sineFunction.getUpperBound(), 0.0001);
    }

    @Test
    public void testRationalFunction() {
        IFunction rationalFunction = new RationalFunction(1, 2, 1, 3, -1, 1);
        assertEquals(0.71, rationalFunction.calculate(0.5), 0.01);
        assertEquals(-1.0, rationalFunction.getLowerBound(), 0.0001);
        assertEquals(1.0, rationalFunction.getUpperBound(), 0.0001);
    }

    @Test
    public void testExponentialFunction() {
        IFunction exponentialFunction = new ExponentialFunction(1, 2, -1, 1);
        assertEquals(Math.exp(1.0), exponentialFunction.calculate(0.5), 0.0001);
        assertEquals(-1.0, exponentialFunction.getLowerBound(), 0.0001);
        assertEquals(1.0, exponentialFunction.getUpperBound(), 0.0001);
    }

    @Test
    public void testOutOfBounds() {
        IFunction linearFunction = new LinearFunction(2, 3, -1, 1);
        try {
            linearFunction.calculate(2);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testDivisionByZero() {
        IFunction rationalFunction = new RationalFunction(1, 2, 1, -1, -1, 1);
        try {
            rationalFunction.calculate(1);
            fail("Expected ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
        }
    }
}
