package org.example.fourthlab;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] solve() {
        if (a == 0) {
            // Линейное уравнение bx + c = 0
            if (b == 0) {
                // Уравнение вырождается в c = 0
                if (c == 0) {
                    // Бесконечное множество решений
                    return new double[]{};
                } else {
                    // Нет решений
                    return new double[]{};
                }
            } else {
                // Один корень
                double root = -c / b;
                return new double[]{root};
            }
        } else {
            // Квадратное уравнение ax^2 + bx + c = 0
            double discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                // Два различных корня
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                return new double[]{root1, root2};
            } else if (discriminant == 0) {
                // Один корень
                double root = -b / (2 * a);
                return new double[]{root};
            } else {
                // Нет реальных корней
                return new double[]{};
            }
        }
    }
}
