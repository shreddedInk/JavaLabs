package org.example.secondsemester.seventhlab.serialize;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {
    private static final long serialVersionUID = 1L;

    private int number;
    private double area;
    private List<Person> owners;

    public Flat() {}

    public Flat(int number, double area, List<Person> owners) {
        this.number = number;
        this.area = area;
        this.owners = owners;
    }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }

    public List<Person> getOwners() { return owners; }
    public void setOwners(List<Person> owners) { this.owners = owners; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number &&
                Double.compare(flat.area, area) == 0 &&
                Objects.equals(owners, flat.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, area, owners);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", area=" + area +
                ", owners=" + owners +
                '}';
    }
}
