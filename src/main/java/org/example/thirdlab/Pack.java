package org.example.thirdlab;

import java.util.Objects;

public class Pack {
    private String title;
    private double packWeight;

    public Pack(String title, double packWeight) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Некорректное название");
        }
        if (packWeight <= 0) {
            throw new IllegalArgumentException("Некорректный вес упаковки");
        }
        this.title = title;
        this.packWeight = packWeight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPackWeight() {
        return packWeight;
    }

    public void setPackWeight(double packWeight) {
        this.packWeight = packWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pack pack)) return false;
        return Double.compare(getPackWeight(), pack.getPackWeight()) == 0 && Objects.equals(getTitle(), pack.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPackWeight());
    }

    @Override
    public String toString() {
        return "Pack{" +
                "title='" + title + '\'' +
                ", packWeight=" + packWeight +
                '}';
    }
}
