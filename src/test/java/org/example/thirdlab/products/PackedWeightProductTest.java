package org.example.thirdlab.products;

import org.example.thirdlab.Pack;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PackedWeightProductTest {
    private PackedWeightIProduct packedWeightProduct;
    private Pack pack;
    private Product product;

    @Before
    public void setUp(){
        product = new Product("Orange","Sour");
        pack = new Pack("Box",1000);
        packedWeightProduct = new PackedWeightIProduct(product,pack,10.5);
    }
    @Test
    public void getNettoMass() {
        Assertions.assertEquals(10.5, packedWeightProduct.getNettoMass());
    }

    @Test
    public void getBruttoMass() {
        Assertions.assertEquals(1010.5, packedWeightProduct.getBruttoMass());
    }
    @Test
    public void exceptionTest(){
        Throwable exception1 = Assertions.assertThrows(IllegalArgumentException.class, ()->{new PackedWeightIProduct(product,pack,-1);});
    }
}