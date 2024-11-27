package org.example.thirdlab.filters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilterPrimeLengthTest {

    @Test
    void apply() {
        String str1 = "123";
        String str2 = "1234";
        FilterPrimeLength filter1 = new FilterPrimeLength(str1);
        FilterPrimeLength filter2 = new FilterPrimeLength(str2);
        Assertions.assertTrue(filter1.apply(str1));
        Assertions.assertFalse(filter2.apply(str2));
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            FilterPrimeLength filter3 = new FilterPrimeLength("");});
    }
}