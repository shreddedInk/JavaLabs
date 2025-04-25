package org.example.firstsemester.thirdlab.products;

import org.example.firstsemester.thirdlab.Pack;
import org.example.firstsemester.thirdlab.interfaces.IProduct;

import java.util.Objects;

public class PackedPieceProduct extends PieceProduct implements IProduct {
    private final int amount;
    private final Pack pack;

    public PackedPieceProduct(int amount, PieceProduct pieceProduct, Pack pack) {
        super(pieceProduct.getName(), pieceProduct.getDescription(), pieceProduct.getWeight());
        if (amount <= 0) {
            throw new IllegalArgumentException("Некорректное кол-во товара");
        }
        this.amount = amount;
        this.pack = pack;
    }

    public int getAmount() {
        return amount;
    }

    public Pack getPack() {
        return pack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackedPieceProduct that)) return false;
        if (!super.equals(o)) return false;
        return getAmount() == that.getAmount() && Objects.equals(getPack(), that.getPack());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAmount(), getPack());
    }

    @Override
    public String toString() {
        return "PackedPieceProduct{" +
                "amount=" + amount +
                ", pack=" + pack +
                '}';
    }

    @Override
    public double getNettoMass() {
        return super.getWeight() * amount;
    }

    @Override
    public double getBruttoMass() {
        return getNettoMass() + pack.getPackWeight();
    }
}
