package org.example.secondsemester.ninethlab;

import java.util.Objects;

public class Human {
    private String lastName;
    private String firstName;
    private String middleName;
    private int age;
    private Gender gender;

    public enum Gender {
        FEMALE, MALE
    }

    public Human(String lastName, String firstName, String middleName, int age, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
    }

    public Human(String lastName, String firstName, int age, Gender gender) {
        this(lastName, firstName, null, age, gender);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Human human = (Human) object;
        return age == human.age && Objects.equals(lastName, human.lastName) && Objects.equals(firstName, human.firstName) && Objects.equals(middleName, human.middleName) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, age, gender);
    }
}