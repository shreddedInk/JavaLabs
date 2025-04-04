package org.example.secondsemester.seventhlab.serialize;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private static final long serialVersionUID = 1L; // Добавляем serialVersionUID

    private String cadastralNumber;
    private String address;
    private Person manager;
    private List<Flat> flats;

    public House() {}

    public House(String cadastralNumber, String address, Person manager, List<Flat> flats) {
        this.cadastralNumber = cadastralNumber;
        this.address = address;
        this.manager = manager;
        this.flats = flats;
    }

    public String getCadastralNumber() { return cadastralNumber; }
    public String getAddress() { return address; }
    public Person getManager() { return manager; }
    public List<Flat> getFlats() { return flats; }

    public void setCadastralNumber(String cadastralNumber) { this.cadastralNumber = cadastralNumber; }
    public void setAddress(String address) { this.address = address; }
    public void setManager(Person manager) { this.manager = manager; }
    public void setFlats(List<Flat> flats) { this.flats = flats; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(cadastralNumber, house.cadastralNumber) &&
                Objects.equals(address, house.address) &&
                Objects.equals(manager, house.manager) &&
                Objects.equals(flats, house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralNumber, address, manager, flats);
    }
}
