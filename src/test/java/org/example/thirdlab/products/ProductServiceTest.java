package org.example.thirdlab.products;

import org.example.thirdlab.Pack;
import org.example.thirdlab.filters.BeginStringFilter;
import org.example.thirdlab.interfaces.IProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductServiceTest {
    Pack bottle = new Pack("Glass bottle", 0.1);
    Pack wrap = new Pack("Candy wrapper", 0.001);
    Pack packet = new Pack("Kraft paper bag", 0.2);
    Pack box = new Pack("Big box abudabi", 0.4);
    PieceProduct juice = new PieceProduct("Juice", "Made of fruits", 1);
    WeightProduct candy = new WeightProduct("Candy", "Not recommended by dentists");
    WeightProduct coffeeBeans = new WeightProduct("Coffee beans", "Smells great!");
    PackedPieceIProduct bottleOfJuice = new PackedPieceIProduct(10, juice, bottle);
    PackedWeightIProduct wrappedCandy = new PackedWeightIProduct(candy, wrap, 0.015);
    PackedWeightIProduct packetOfCoffeeBeans = new PackedWeightIProduct(coffeeBeans, packet, 3.5);
    IProduct[] packSet;
    IProduct[] packSet2;
    PackedIProductSet packedProductSet;
    PackedIProductSet packedProductSet2;
    IProduct[] packBatch;
    ProductBatch productBatch;
    BeginStringFilter filter;
    IProduct[] weightedSet;
    ProductBatch weightedBatch;
    @BeforeEach
    public void setUp(){
        packSet = new IProduct[]{bottleOfJuice, wrappedCandy, packetOfCoffeeBeans};
        packedProductSet = new PackedIProductSet("Candy and other products", box,packSet);
        packSet2 = new IProduct[]{wrappedCandy, packedProductSet};
        packedProductSet2 = new PackedIProductSet("Candy and other other", box, packSet2);
        packBatch = new IProduct[]{bottleOfJuice, wrappedCandy, packedProductSet2};
        productBatch =new ProductBatch(packBatch, "batch for test");
        filter = new BeginStringFilter("Candy");
        weightedSet = new IProduct[]{wrappedCandy, packetOfCoffeeBeans};
        weightedBatch = new ProductBatch(weightedSet, "weighted");
    }
    @Test
    public void countByFilter() {
        Assertions.assertEquals(2, ProductService.countByFilter(productBatch, filter));
    }

    @Test
    public void countByFilterDeep() {
        Assertions.assertEquals(4, ProductService.countByFilterDeep(productBatch, filter));
    }

    @Test
    public void checkAllWeighted() {
        Assertions.assertTrue(ProductService.checkAllWeighted(weightedBatch));
        Assertions.assertFalse(ProductService.checkAllWeighted(productBatch));
    }
}