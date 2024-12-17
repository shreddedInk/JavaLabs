package org.example.fourthlab.task1;

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
            if (b == 0) {
                if (c == 0) {
                    return new double[]{};
                } else {
                    return new double[]{};
                }


            } else {
                double root = -c / b;
                return new double[]{root};
            }
        }


        else {
            double discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                return new double[]{root1, root2};
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                return new double[]{root};
            } else {
                return new double[]{};
            }
        }
    }
}
