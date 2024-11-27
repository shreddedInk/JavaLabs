package org.example.thirdlab.products;

import org.example.thirdlab.products.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProductTest {
    private Product product1;
    private Product product2;
    private Product product3;
    @Test
    public void exceptionTest(){
        Throwable exception1 = Assertions.assertThrows(IllegalArgumentException.class, ()->{new Product("","");});
        Throwable exception2 = Assertions.assertThrows(IllegalArgumentException.class, ()->{new Product("   ","abc");});
    }
    @Test
    public void getName() {
        product1 = new Product("Bread","Tasty");
        product2 = new Product("Water", "Liquid");
        Assertions.assertEquals("Bread", product1.getName());
        Assertions.assertEquals("Water", product2.getName());
    }

    @Test
    public void getDescription() {
        product1 = new Product("Bread","Tasty");
        product2 = new Product("Water", "Liquid");
        product3 = new Product("SomethingWithoutDescription","");
        Assertions.assertEquals("Tasty", product1.getDescription());
        Assertions.assertEquals("Liquid", product2.getDescription());
        Assertions.assertEquals("", product3.getDescription());
    }
}