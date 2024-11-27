package org.example.thirdlab.products;

import java.util.Objects;

public class PieceProduct extends Product {
    private final double weight;

    public PieceProduct(String name, String description, double weight) {
        super(name, description);
        if (weight <= 0) {
            throw new IllegalArgumentException("Неправильно задан вес");
        }
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PieceProduct that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getWeight(), that.getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeight());
    }

    @Override
    public String toString() {
        return "PieceProduct{" +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", weight=" + weight +
                '}';
    }
}
