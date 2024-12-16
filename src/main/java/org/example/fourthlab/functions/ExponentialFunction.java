package org.example.fourthlab.functions;

public class ExponentialFunction implements IFunction {
    private final double a;
    private final double b;
    private final double lowerBound;
    private final double upperBound;

    public ExponentialFunction(double a, double b, double lowerBound, double upperBound) {
        this.a = a;
        this.b = b;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public double calculate(double x) {
        if (x < lowerBound || x > upperBound) {
            throw new IllegalArgumentException("Argument out of bounds");
        }
        return a * Math.exp(b * x);
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
