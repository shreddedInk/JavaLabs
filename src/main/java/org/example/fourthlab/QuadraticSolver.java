package org.example.fourthlab;

public class QuadraticSolver {
    private QuadraticEquation equation;

    public QuadraticSolver(QuadraticEquation equation) {
        this.equation = equation;
    }

    public double getLargestRoot() throws NoRealRootsException {
        double[] roots = equation.solve();
        if (roots.length == 0) {
            throw new NoRealRootsException("No real roots found.");
        }
        return roots[roots.length - 1];
    }
}

class NoRealRootsException extends Exception {
    public NoRealRootsException(String message) {
        super(message);
    }
}

