package org.example.firstsemester.fourthlab.task1;

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
        double largestRoot = roots[0];
        for (double root : roots) {
            if (root > largestRoot) {
                largestRoot = root;
            }
        }
        return largestRoot;
    }
}

class NoRealRootsException extends Exception {
    public NoRealRootsException(String message) {
        super(message);
    }
}
