package org.example.thirdlab.products;

import org.example.thirdlab.Pack;
import org.example.thirdlab.interfaces.IProduct;

import java.util.Objects;

public class PackedWeightProduct extends WeightProduct implements IProduct {
    private Pack pack;
    private double weight;

    public PackedWeightProduct(Product product, Pack pack, double weight) {
        super(product.getName(), product.getDescription());
        if (pack.getPackWeight() <= 0) {
            throw new IllegalArgumentException("Некорректный вес упаковки");
        }
        if (pack.getTitle().isBlank()) {
            throw new IllegalArgumentException("Некорректное название");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Некорректный вес товара");
        }
        this.pack = pack;
        this.weight = weight;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackedWeightProduct that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getWeight(), that.getWeight()) == 0 && Objects.equals(getPack(), that.getPack());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPack(), getWeight());
    }

    @Override
    public String toString() {
        return "PackedWeightProduct{" +
                "pack=" + pack +
                ", weight=" + weight +
                '}';
    }

    @Override
    public double getNettoMass() {
        return weight;
    }

    @Override
    public double getBruttoMass() {
        return getNettoMass() + pack.getPackWeight();
    }
}
