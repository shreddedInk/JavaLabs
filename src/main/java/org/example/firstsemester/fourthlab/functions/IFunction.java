package org.example.firstsemester.fourthlab.functions;

public interface IFunction {
    /**
     * Вычисляет значение функции при заданном аргументе.
     *
     * @param x аргумент функции
     * @return значение функции при заданном аргументе
     * @throws IllegalArgumentException если аргумент x находится вне отрезка [a; b]
     */
    double calculate(double x);

    /**
     * Возвращает нижнюю границу отрезка.
     *
     * @return нижняя граница отрезка
     */
    double getLowerBound();

    /**
     * Возвращает верхнюю границу отрезка.
     *
     * @return верхняя граница отрезка
     */
    double getUpperBound();
}
