package org.example.fourthlab.functions;

import org.example.fourthlab.functionals.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionalTest {

    @Test
    public void testSumFunctional() {
        IFunction linearFunction = new LinearFunction(2, 3, -1, 1);
        IFunctional<IFunction> sumFunctional = new SumFunctional<>();
        assertEquals(9.0, sumFunctional.calculate(linearFunction), 0.0001);
    }

    @Test
    public void testSumFunctionalSine() {
        IFunction sineFunction = new SinusFunction(2, 10, 0, 2*Math.PI);
        IFunctional<IFunction> sumFunctional = new SumFunctional<>();
        assertEquals(0.0, sumFunctional.calculate(sineFunction), 0.0001);
    }

    @Test
    public void testIntegralFunctionalExponential() {
        IFunction exponentialFunction = new ExponentialFunction(1, 1, 0, 1);
        IFunctional<IFunction> integralFunctional = new IntegralFunctional<>(0, 1, 0.0001);
        assertEquals(Math.exp(1) - 1, integralFunctional.calculate(exponentialFunction), 0.0001);
    }

    @Test
    public void testIntegralFunctionalOutOfBounds() {
        IFunction linearFunction = new LinearFunction(2, 3, -1, 1);
        IFunctional<IFunction> integralFunctional = new IntegralFunctional<>(-2, 2, 0.0001);

        boolean exceptionThrown = false;
        try {
            integralFunctional.calculate(linearFunction);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown, "Expected IllegalArgumentException to be thrown");
    }

    @Test
    public void testIntegralFunctionalLinear() {
        IFunction linearFunction = new LinearFunction(2, 3, -1, 1);
        IFunctional<IFunction> integralFunctional = new IntegralFunctional<>(-1, 1, 0.0001);
        assertEquals(6.0, integralFunctional.calculate(linearFunction), 0.0001);
    }

    @Test
    public void testIntegralFunctionalSine() {
        IFunction sineFunction = new SinusFunction(1, 1, 0, Math.PI);
        IFunctional<IFunction> integralFunctional = new IntegralFunctional<>(0, Math.PI, 0.0001);
        assertEquals(2.0, integralFunctional.calculate(sineFunction), 0.0001);
    }

    @Test
    public void testIntegralFunctionalCosine() {
        IFunction sineFunction = new SinusFunction(1, 1, 0, Math.PI / 2);
        IFunctional<IFunction> integralFunctional = new IntegralFunctional<>(0, Math.PI / 2, 0.0001);
        assertEquals(1.0, integralFunctional.calculate(sineFunction), 0.0001);
    }

    @Test
    public void testIntegralFunctionalRational2() {
        IFunction rationalFunction = new RationalFunction(2, 3, 5, 1, 1, 10);
        IFunctional<IFunction> integralFunctional = new IntegralFunctional<>(1, 10, 0.0001);
        double expected = (13.0 / 25.0) * Math.log(51.0 / 6.0) + 18.0 / 5.0;
        assertEquals(expected, integralFunctional.calculate(rationalFunction), 0.0001);
    }
}
