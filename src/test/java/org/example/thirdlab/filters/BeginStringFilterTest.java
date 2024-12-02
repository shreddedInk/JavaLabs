package org.example.thirdlab.filters;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BeginStringFilterTest {
    String str = "Мама мыла раму";

    @Test
    public void apply() {
        BeginStringFilter filter1 = new BeginStringFilter("Мама");
        BeginStringFilter filter2 = new BeginStringFilter("раму");
        Assertions.assertTrue(filter1.apply(str));
        Assertions.assertFalse(filter2.apply(str));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fail() {
        BeginStringFilter filter3 = new BeginStringFilter("");
    }
}
