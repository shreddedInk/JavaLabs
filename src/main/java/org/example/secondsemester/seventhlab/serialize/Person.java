package org.example.secondsemester.seventhlab.serialize;

import java.io.*;
import java.util.*;
import java.util.Objects;

class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;

    public Person(String firstName, String lastName, String middleName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMiddleName() { return middleName; }
    public Date getBirthDate() { return birthDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(middleName, person.middleName) &&
                Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, birthDate);
    }
}
