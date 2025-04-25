package org.example.firstsemester.thirdlab.filters;

import org.example.firstsemester.thirdlab.filters.ContainsFilter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ContainsFilterTest {
    String str = "Мама мыла раму";

    @Test
    public void apply() {
        ContainsFilter filter1 = new ContainsFilter("Мама");
        ContainsFilter filter2 = new ContainsFilter("раму");
        Assertions.assertTrue(filter1.apply(str));
        Assertions.assertTrue(filter2.apply(str));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fail() {
        ContainsFilter filter3 = new ContainsFilter("");
    }

    @Test
    public void apply2() {
        ContainsFilter filter4 = new ContainsFilter("NONONO");
        Assertions.assertFalse(filter4.apply(str));
    }
}
