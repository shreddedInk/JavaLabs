package org.example.fourthlab.functionals;

import org.example.fourthlab.functions.IFunction;

public class SumFunctional<T extends IFunction> implements IFunctional<T> {
    @Override
    public double calculate(T function) {
        double sum = 0;
        double step = 1;
        for (double x = function.getLowerBound(); x <= function.getUpperBound(); x += step) {
            sum += function.calculate(x);
        }
        return sum;
    }
}
