package org.example.fourthlab.functionals;

import org.example.fourthlab.functions.IFunction;

public interface IFunctional<T extends IFunction> {
    /**
     * Вычисляет значение функционала от заданной функции.
     *
     * @param function функция, от которой вычисляется значение функционала
     * @return значение функционала
     */
    double calculate(T function);
}

