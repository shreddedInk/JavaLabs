package org.example.fourthlab.functionals;

import org.example.fourthlab.functions.IFunction;

public class SumFunctional<T extends IFunction> implements IFunctional<T> {
    @Override
    public double calculate(T function) {
        double lowerBound = function.getLowerBound();
        double upperBound = function.getUpperBound();
        double middle = (lowerBound + upperBound) / 2;

        double leftValue = function.calculate(lowerBound);
        double rightValue = function.calculate(upperBound);
        double middleValue = function.calculate(middle);

        return leftValue + rightValue + middleValue;
    }
}
