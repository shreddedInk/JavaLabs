package org.example.thirdlab.products;

import org.example.thirdlab.Pack;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PackedPieceProductTest {
    private PackedPieceIProduct packedPieceProduct;
    private Pack pack;
    private PieceProduct pieceProduct;
    @Before
    public void setUp(){
        pieceProduct = new PieceProduct("Cucumber","Green",100);
        pack = new Pack("Plastic bag", 0.1);
        packedPieceProduct = new PackedPieceIProduct(5,pieceProduct,pack);
    }
    @Test
    public void getNettoMass() {
        Assertions.assertEquals(500, packedPieceProduct.getNettoMass());
    }

    @Test
    public void getBruttoMass() {
        Assertions.assertEquals(500.1, packedPieceProduct.getBruttoMass());
    }
    @Test
    public void exceptionTest(){
        Throwable exception1 = Assertions.assertThrows(IllegalArgumentException.class, ()->{new PackedPieceIProduct(-1,pieceProduct,pack);});
    }
}