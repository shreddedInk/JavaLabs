package org.example.secondsemester.seventhlab.serialize;

import java.io.*;
import java.util.*;
import java.util.Objects;


class House implements Serializable {
    private String cadastralNumber;
    private String address;
    private Person senior;
    private List<Flat> flats;

    public House(String cadastralNumber, String address, Person senior, List<Flat> flats) {
        this.cadastralNumber = cadastralNumber;
        this.address = address;
        this.senior = senior;
        this.flats = flats;
    }

    public String getCadastralNumber() { return cadastralNumber; }
    public String getAddress() { return address; }
    public Person getSenior() { return senior; }
    public List<Flat> getFlats() { return flats; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(cadastralNumber, house.cadastralNumber) &&
                Objects.equals(address, house.address) &&
                Objects.equals(senior, house.senior) &&
                Objects.equals(flats, house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralNumber, address, senior, flats);
    }
}
