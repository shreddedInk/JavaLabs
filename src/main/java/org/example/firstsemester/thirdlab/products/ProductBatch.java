package org.example.firstsemester.thirdlab.products;

import org.example.firstsemester.thirdlab.interfaces.IProduct;

import java.util.Arrays;
import java.util.Objects;

public class ProductBatch {
    private final IProduct[] products;
    private final String description;

    public ProductBatch(IProduct[] products, String description) {
        if (products == null) {
            throw new NullPointerException("Некорректный массив");
        }
        this.description = description;
        this.products = new IProduct[products.length];
        System.arraycopy(products, 0, this.products, 0, products.length);
    }

    public IProduct[] getProducts() {
        return products;
    }

    public String getDescription() {
        return description;
    }

    public double getBatchMass() {
        double mass = 0;
        for (IProduct item : products) {
            if (item != null) {
                mass += item.getBruttoMass();
            }
        }
        return mass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductBatch that)) return false;
        return Arrays.equals(getProducts(), that.getProducts()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getDescription());
        result = 31 * result + Arrays.hashCode(getProducts());
        return result;
    }

    @Override
    public String toString() {
        return "ProductBatch{" +
                "products=" + Arrays.toString(products) +
                ", description='" + description + '\'' +
                '}';
    }
}
