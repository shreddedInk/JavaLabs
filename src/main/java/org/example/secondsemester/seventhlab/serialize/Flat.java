package org.example.secondsemester.seventhlab.serialize;

import java.io.*;
import java.util.*;
import java.util.Objects;


class Flat implements Serializable {
    private int number;
    private double area;
    private List<Person> owners;

    public Flat(int number, double area, List<Person> owners) {
        this.number = number;
        this.area = area;
        this.owners = owners;
    }

    public int getNumber() { return number; }
    public double getArea() { return area; }
    public List<Person> getOwners() { return owners; }

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
}
