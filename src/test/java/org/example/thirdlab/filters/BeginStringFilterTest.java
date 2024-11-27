package org.example.thirdlab.filters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BeginStringFilterTest {
    @Test
    void apply() {
        String str = "Мама мыла раму";
        BeginStringFilter filter1 = new BeginStringFilter("Мама");
        BeginStringFilter filter2 = new BeginStringFilter("раму");
        Assertions.assertTrue(filter1.apply(str));
        Assertions.assertFalse(filter2.apply(str));
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            BeginStringFilter filter3 = new BeginStringFilter("");});
    }
}