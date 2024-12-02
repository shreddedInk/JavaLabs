package org.example.thirdlab.products;

import org.example.thirdlab.Pack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PackedPieceProductTest {
    PieceProduct product = new PieceProduct("Makaroni", "Sweety", 100);
    Pack pack = new Pack("Plastic bag", 0.1);

    @Test
    public void testWeightCalculations() {
        PackedPieceProduct packedProduct = new PackedPieceProduct(5, product, pack);

        assertEquals(500, packedProduct.getNettoMass());
        assertEquals(500.1, packedProduct.getBruttoMass(), 0.01);
    }

    @Test
    public void testNegativeQuantity() {
        try {
            new PackedPieceProduct(-1, product, pack);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
