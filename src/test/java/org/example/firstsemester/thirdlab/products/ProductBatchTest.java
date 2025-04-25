package org.example.firstsemester.thirdlab.products;

import org.example.firstsemester.thirdlab.Pack;
import org.example.firstsemester.thirdlab.interfaces.IProduct;
import org.example.firstsemester.thirdlab.products.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class ProductBatchTest {
    Pack bottle = new Pack("Glass bottle", 0.1);
    Pack wrap = new Pack("Candy wrapper", 0.001);
    Pack packet = new Pack("Kraft paper bag", 0.2);
    Pack box = new Pack("Big box abudabi", 0.4);
    PieceProduct juice = new PieceProduct("Juice", "Made of fruits", 1);
    PackedPieceProduct bottleOfJuice = new PackedPieceProduct(10, juice, bottle);
    WeightProduct candy = new WeightProduct("Candy", "Not recommended by dentists");
    PackedWeightProduct wrappedCandy = new PackedWeightProduct(candy, wrap, 0.015);
    PackedProductSet packedProductSet;
    IProduct[] packSet;
    IProduct[] packBatch;
    ProductBatch productBatch;

    @Before
    public void setUp() {
        packSet = new IProduct[]{bottleOfJuice, wrappedCandy};
        packedProductSet = new PackedProductSet("Product set", packet, packSet);
        packBatch = new IProduct[]{bottleOfJuice, wrappedCandy, packedProductSet};
        productBatch = new ProductBatch(packBatch, "batch for test");
    }

    @Test
    public void getProducts() {
        Assertions.assertEquals(Arrays.toString(packBatch), Arrays.toString(productBatch.getProducts()));
    }

    @Test
    public void getBatchMass() {
        Assertions.assertEquals(20.432, productBatch.getBatchMass());
    }
}