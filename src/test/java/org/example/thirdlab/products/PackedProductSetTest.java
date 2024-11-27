package org.example.thirdlab.products;

import org.example.thirdlab.*;
import org.example.thirdlab.interfaces.IProduct;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class PackedProductSetTest {
    Pack bottle = new Pack("Glass bottle", 0.1);
    Pack wrap = new Pack("Candy wrapper", 0.001);
    Pack packet = new Pack("Kraft paper bag", 0.2);
    PieceProduct juice = new PieceProduct("Juice", "Made of fruits", 1);
    PackedPieceIProduct bottleOfJuice = new PackedPieceIProduct(1, juice, bottle);
    WeightProduct candy = new WeightProduct("Candy", "Not recommended by dentists");
    PackedWeightIProduct wrappedCandy = new PackedWeightIProduct(candy, wrap, 0.015);
    PackedIProductSet packedProductSet;
    IProduct[] packaged;
    @Before
    public void setUp() {
        packaged = new IProduct[]{bottleOfJuice, wrappedCandy};
        packedProductSet = new PackedIProductSet("Упакованный набор товаров", packet, packaged);
    }

    @Test
    public void getPackedItems() {
        Assertions.assertEquals(Arrays.toString(packaged), Arrays.toString(packedProductSet.getPackedItems()));
    }

    @Test
    public void getNettoMass() {
        Assertions.assertEquals(1.116, packedProductSet.getNettoMass());
    }

    @Test
    public void getBruttoMass() {
        Assertions.assertEquals(1.316, packedProductSet.getBruttoMass());
    }
}