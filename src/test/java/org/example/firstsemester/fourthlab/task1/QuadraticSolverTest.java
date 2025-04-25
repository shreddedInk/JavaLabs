package org.example.firstsemester.fourthlab.task1;

import org.example.firstsemester.fourthlab.task1.NoRealRootsException;
import org.example.firstsemester.fourthlab.task1.QuadraticEquation;
import org.example.firstsemester.fourthlab.task1.QuadraticSolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadraticSolverTest {

    @Test
    public void testGetLargestRootWithTwoRealRoots() throws NoRealRootsException {
        QuadraticEquation equation = new QuadraticEquation(1, 7, 6);
        QuadraticSolver solver = new QuadraticSolver(equation);
        double largestRoot = solver.getLargestRoot();
        assertEquals(-1.0, largestRoot, 0.0001); // -6 -1
    }

    @Test
    public void testGetLargestRootWithOneRealRoot() throws NoRealRootsException {
        QuadraticEquation equation = new QuadraticEquation(1, -2, 1);
        QuadraticSolver solver = new QuadraticSolver(equation);
        double largestRoot = solver.getLargestRoot();
        assertEquals(1.0, largestRoot, 0.0001);
    }

    @Test
    public void testGetLargestRootWithNoRealRoots() {
        QuadraticEquation equation = new QuadraticEquation(1, 1, 1);
        QuadraticSolver solver = new QuadraticSolver(equation);
        assertThrows(NoRealRootsException.class, solver::getLargestRoot);
    }

    @Test
    public void testGetLargestRootWithZeroCoefficients() {
        QuadraticEquation equation = new QuadraticEquation(0, 0, 0);
        QuadraticSolver solver = new QuadraticSolver(equation);
        assertThrows(NoRealRootsException.class, solver::getLargestRoot);
    }

    @Test
    public void testGetLargestRootWithLinearEquation() throws NoRealRootsException {
        QuadraticEquation equation = new QuadraticEquation(0, 2, -4);
        QuadraticSolver solver = new QuadraticSolver(equation);
        double largestRoot = solver.getLargestRoot();
        assertEquals(2.0, largestRoot, 0.0001);
    }
}
