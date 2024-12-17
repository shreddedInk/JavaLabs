package org.example.fourthlab.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadraticEquationTest {

    @Test
    public void testTwoRealRoots() {
        QuadraticEquation equation = new QuadraticEquation(1, 7, 6);
        double[] roots = equation.solve();
        assertEquals(2, roots.length);
        assertEquals(-1.0, roots[0], 0.0001);
        assertEquals(-6.0, roots[1], 0.0001);
    }

    @Test
    public void testOneRealRoot() {
        QuadraticEquation equation = new QuadraticEquation(1, -2, 1);
        double[] roots = equation.solve();
        assertEquals(1, roots.length);
        assertEquals(1.0, roots[0], 0.0001);
    }

    @Test
    public void testNoRealRoots() {
        QuadraticEquation equation = new QuadraticEquation(1, 1, 1);
        double[] roots = equation.solve();
        assertEquals(0, roots.length);
    }

    @Test
    public void testZeroCoefficients() {
        QuadraticEquation equation = new QuadraticEquation(0, 0, 0);
        double[] roots = equation.solve();
        assertEquals(0, roots.length);
    }

    @Test
    public void testLinearEquation() {
        QuadraticEquation equation = new QuadraticEquation(0, 2, -4);
        double[] roots = equation.solve();
        assertEquals(1, roots.length);
        assertEquals(2.0, roots[0], 0.0001);
    }
}
