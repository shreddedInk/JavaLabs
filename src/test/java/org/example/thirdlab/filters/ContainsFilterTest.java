package org.example.thirdlab.filters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainsFilterTest {

    @Test
    void apply() {
        String str = "Мама мыла раму";
        ContainsFilter filter1 = new ContainsFilter("Мама");
        ContainsFilter filter2 = new ContainsFilter("раму");
        Assertions.assertTrue(filter1.apply(str));
        Assertions.assertTrue(filter2.apply(str));
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            ContainsFilter filter3 = new ContainsFilter("");});
        ContainsFilter filter4 = new ContainsFilter("NONONO");
        Assertions.assertFalse(filter4.apply(str));
    }
}