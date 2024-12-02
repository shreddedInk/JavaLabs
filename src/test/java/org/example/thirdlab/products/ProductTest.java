package org.example.thirdlab.products;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProductTest {
    private Product product1;
    private Product product2;
    private Product product3;

    @Test(expected = IllegalArgumentException.class)
    public void exceptionTest1() {
        new Product("", "");
    }

    @Test
    public void exceptionTest2() {
        new Product("   ", "abc");
    }

    @Test
    public void getName() {
        product1 = new Product("", "yea");
        product2 = new Product("Water", "water...");
        Assertions.assertEquals("yea", product1.getName());
        Assertions.assertEquals("water...", product2.getName());
    }

    @Test
    public void getDescription() {
        product1 = new Product("Water", "Tasty");
        product2 = new Product("Me", "Nothing");
        product3 = new Product("NoDescription", "");
        Assertions.assertEquals("Tasty", product1.getDescription());
        Assertions.assertEquals("Nothing", product2.getDescription());
        Assertions.assertEquals("", product3.getDescription());
    }
}