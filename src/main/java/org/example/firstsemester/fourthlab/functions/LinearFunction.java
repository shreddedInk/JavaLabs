package org.example.firstsemester.fourthlab.functions;

// f(x) = Ax + B
public class LinearFunction implements IFunction {
    private final double a;
    private final double b;
    private final double lowerBound;
    private final double upperBound;

    public LinearFunction(double a, double b, double lowerBound, double upperBound) {
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
        return a * x + b;
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
