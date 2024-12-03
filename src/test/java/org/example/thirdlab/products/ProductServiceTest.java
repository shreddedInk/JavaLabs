package org.example.thirdlab.products;

import org.example.thirdlab.Pack;
import org.example.thirdlab.filters.BeginStringFilter;
import org.example.thirdlab.interfaces.IProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductServiceTest {
    Pack bottle = new Pack("Glass bottle", 0.1);
    Pack wrap = new Pack("Candy wrapper", 0.001);
    Pack packet = new Pack("Kraft paper bag", 0.2);
    Pack box = new Pack("Big box abudabi", 0.4);
    PieceProduct juice = new PieceProduct("Juice", "Made of fruits", 1);
    WeightProduct candy = new WeightProduct("Candy", "Not recommended by dentists");
    WeightProduct coffeeBeans = new WeightProduct("Coffee beans", "Smells great!");
    PackedPieceProduct bottleOfJuice = new PackedPieceProduct(10, juice, bottle);
    PackedWeightProduct wrappedCandy = new PackedWeightProduct(candy, wrap, 0.015);
    PackedWeightProduct packetOfCoffeeBeans = new PackedWeightProduct(coffeeBeans, packet, 3.5);
    IProduct[] packSet;
    IProduct[] packSet2;
    PackedProductSet packedProductSet;
    PackedProductSet packedProductSet2;
    IProduct[] packBatch;
    ProductBatch productBatch;
    BeginStringFilter filter;
    IProduct[] weightedSet;
    ProductBatch weightedBatch;

    @BeforeEach
    public void setUp() {
        packSet = new IProduct[]{bottleOfJuice, wrappedCandy, packetOfCoffeeBeans};
        packedProductSet = new PackedProductSet("DSADASDA", box, packSet);
        packSet2 = new IProduct[]{wrappedCandy, packedProductSet};
        packedProductSet2 = new PackedProductSet("Lemon Tree the best lemons for anyone", box, packSet2);
        packBatch = new IProduct[]{bottleOfJuice, wrappedCandy, packedProductSet2};
        productBatch = new ProductBatch(packBatch, "batch with blood");
        filter = new BeginStringFilter("Lemon");
        weightedSet = new IProduct[]{wrappedCandy, packetOfCoffeeBeans};
        weightedBatch = new ProductBatch(weightedSet, "weighted");
    }

    @Test
    public void countByFilter() {
        Assertions.assertEquals(1, ProductService.countByFilter(productBatch, filter));
    }

    @Test
    public void countByFilterDeep() {
        Assertions.assertEquals(1, ProductService.countByFilterDeep(productBatch, filter));
    }

    @Test
    public void checkAllWeighted() {
        Assertions.assertTrue(ProductService.checkAllWeighted(weightedBatch));
        Assertions.assertFalse(ProductService.checkAllWeighted(productBatch));
    }
}