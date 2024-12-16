package org.example.fourthlab.functions;

public class RationalFunction implements IFunction {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double lowerBound;
    private final double upperBound;

    public RationalFunction(double a, double b, double c, double d, double lowerBound, double upperBound) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public double calculate(double x) {
        if (x < lowerBound || x > upperBound) {
            throw new IllegalArgumentException("Argument out of bounds");
        }
        if (c * x + d == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (a * x + b) / (c * x + d);
    }

    @Override
    public double getLowerBound() {
        return lowerBound;
    }

    @Override
    public double getUpperBound() {
        return upperBound;
    }
}
