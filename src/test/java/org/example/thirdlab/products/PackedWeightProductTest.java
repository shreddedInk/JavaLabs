package org.example.thirdlab.products;

import org.example.thirdlab.Pack;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PackedWeightProductTest {
    private PackedWeightProduct packedWeightProduct;
    private Pack pack;
    private Product product;

    @Before
    public void setUp() {
        product = new Product("Orange", "");
        pack = new Pack("Box", 1000);
        packedWeightProduct = new PackedWeightProduct(product, pack, 10.5);
    }

    @Test
    public void getNettoMass() {
        Assertions.assertEquals(10.5, packedWeightProduct.getNettoMass());
    }

    @Test
    public void getBruttoMass() {
        Assertions.assertEquals(1010.5, packedWeightProduct.getBruttoMass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionTest() {
        new PackedWeightProduct(product, pack, -1);
    }
}