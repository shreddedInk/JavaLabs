package org.example.firstsemester.thirdlab.products;

import org.example.firstsemester.thirdlab.Pack;
import org.example.firstsemester.thirdlab.filters.BeginStringFilter;
import org.example.firstsemester.thirdlab.filters.ContainsFilter;
import org.example.firstsemester.thirdlab.filters.EndStringFilter;
import org.example.firstsemester.thirdlab.interfaces.IProduct;
import org.example.firstsemester.thirdlab.products.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductServiceTest {
    Pack bottle = new Pack("Glass Bottle", 0.1);
    Pack wrapper = new Pack("Candy Wrapper", 0.001);
    Pack bag = new Pack("Paper Bag", 0.2);
    Pack box = new Pack("Storage Box", 0.4);
    Pack lemonPack = new Pack("Lemon Packaging", 0.5);
    PieceProduct juice = new PieceProduct("Apple Juice", "Made from fresh apples", 1);
    PieceProduct lemonTree = new PieceProduct("Lemon Tree", "Fresh and organic", 1);
    WeightProduct candy = new WeightProduct("Chocolate Candy", "Sweet and delicious");
    WeightProduct coffee = new WeightProduct("Coffee Beans Bag", "Rich aroma and taste");
    PackedPieceProduct juiceBottle = new PackedPieceProduct(10, juice, bottle);
    PackedWeightProduct candyWrapper = new PackedWeightProduct(candy, wrapper, 0.015);
    PackedWeightProduct coffeeBag = new PackedWeightProduct(coffee, bag, 3.5);
    PackedPieceProduct lemonTreeBox = new PackedPieceProduct(50, lemonTree, lemonPack);

    IProduct[] productArray;
    PackedProductSet productSet;
    IProduct[] nestedArray;
    PackedProductSet nestedSet;
    IProduct[] batchArray;
    ProductBatch productBatch;

    BeginStringFilter beginFilter;
    EndStringFilter endFilter;
    ContainsFilter containsFilter;

    @BeforeEach
    public void setUp() {
        productArray = new IProduct[]{juiceBottle, candyWrapper, coffeeBag, lemonTreeBox};
        productSet = new PackedProductSet("Boxed Items", box, productArray);

        nestedArray = new IProduct[]{candyWrapper, lemonTreeBox, productSet};
        nestedSet = new PackedProductSet("Nested Box", box, nestedArray);

        batchArray = new IProduct[]{juiceBottle, candyWrapper, coffeeBag, lemonTreeBox, nestedSet};
        productBatch = new ProductBatch(batchArray, "Mixed Products Batch");

        beginFilter = new BeginStringFilter("Lemon"); // "Lemon Tree" и "Lemon Tree Box"
        endFilter = new EndStringFilter("Bag"); // "Coffee Bag" и "Paper Bag"
        containsFilter = new ContainsFilter("Candy"); // "Candy Wrapper" и "Chocolate Candy"
    }



    @Test
    public void testCountByFilter() {
        Assertions.assertEquals(1, ProductService.countByFilter(productBatch, beginFilter));
        Assertions.assertEquals(1, ProductService.countByFilter(productBatch, endFilter));
        Assertions.assertEquals(1, ProductService.countByFilter(productBatch, containsFilter));
    }

    @Test
    public void testCountByFilterDeep() {
        Assertions.assertEquals(3, ProductService.countByFilterDeep(productBatch, beginFilter)); // Lemon Tree и Lemon Tree Box
        Assertions.assertEquals(2, ProductService.countByFilterDeep(productBatch, endFilter)); // Coffee Bag и Paper Bag
        Assertions.assertEquals(3, ProductService.countByFilterDeep(productBatch, containsFilter)); // Candy Wrapper и Chocolate Candy
    }

    @Test
    public void testCheckAllWeighted() {
        IProduct[] weightedProducts = new IProduct[]{candyWrapper, coffeeBag};
        ProductBatch weightedBatch = new ProductBatch(weightedProducts, "Weighted Only Batch");

        Assertions.assertTrue(ProductService.checkAllWeighted(weightedBatch));
        Assertions.assertFalse(ProductService.checkAllWeighted(productBatch));
    }
}
