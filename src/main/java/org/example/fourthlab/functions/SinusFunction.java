package org.example.fourthlab.functions;

public class SinusFunction implements IFunction {
    private final double amplitude;
    private final double frequency;
    private final double lowerBound;
    private final double upperBound;

    public SinusFunction(double amplitude, double frequency, double lowerBound, double upperBound) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public double calculate(double x) {
        if (x < lowerBound || x > upperBound) {
            throw new IllegalArgumentException("Argument out of bounds");
        }
        return amplitude * Math.sin(frequency * x);
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
