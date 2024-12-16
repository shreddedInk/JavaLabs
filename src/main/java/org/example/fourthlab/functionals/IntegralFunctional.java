package org.example.fourthlab.functionals;

import org.example.fourthlab.functions.IFunction;

public class IntegralFunctional<T extends IFunction> implements IFunctional<T> {
    private final double a;
    private final double b;
    private final double tolerance;

    public IntegralFunctional(double a, double b, double tolerance) {
        this.a = a;
        this.b = b;
        this.tolerance = tolerance;
    }

    @Override
    public double calculate(T function) {
        if (function.getLowerBound() > a || function.getUpperBound() < b) {
            throw new IllegalArgumentException("Function domain is not within the integration limits.");
        }

        int n = 1;
        double previousIntegral = 0;
        double currentIntegral = 0;

        do {
            n *= 2;
            previousIntegral = currentIntegral;
            currentIntegral = calculateIntegral(function, n);
        } while (Math.abs(currentIntegral - previousIntegral) > tolerance);

        return currentIntegral;
    }

    private double calculateIntegral(T function, int n) {
        double h = (b - a) / n;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            double x = a + i * h + h / 2;
            sum += function.calculate(x);
        }

        return sum * h;
    }
}
