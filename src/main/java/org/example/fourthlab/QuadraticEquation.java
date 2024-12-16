package org.example.fourthlab;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public double getFirstCoefficient() {
        return a;
    }

    public void setFirstCoefficient(double a) {
        this.a = a;
    }

    public double getSecondCoefficient() {
        return b;
    }

    public void setSecondCoefficient(double b) {
        this.b = b;
    }

    public double getThirdCoefficient() {
        return c;
    }

    public void setThirdCoefficient(double c) {
        this.c = c;
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] solve() {
        double a = this.a;
        double b = this.b;
        double c = this.c;

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

