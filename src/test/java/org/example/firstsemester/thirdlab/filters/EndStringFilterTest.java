package org.example.firstsemester.thirdlab.filters;

import org.example.firstsemester.thirdlab.filters.EndStringFilter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EndStringFilterTest {
    String str = "Мама мыла раму";

    @Test
    public void apply() {
        EndStringFilter filter1 = new EndStringFilter("раму");
        EndStringFilter filter2 = new EndStringFilter("мыла раму");
        Assertions.assertTrue(filter1.apply(str));
        Assertions.assertTrue(filter2.apply(str));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fail() {
        EndStringFilter filter3 = new EndStringFilter("");
    }

    @Test
    public void apply2() {
        EndStringFilter filter4 = new EndStringFilter("Мама");
        Assertions.assertFalse(filter4.apply(str));
    }
}
