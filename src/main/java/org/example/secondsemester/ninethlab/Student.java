package org.example.secondsemester.ninethlab;

import java.util.Objects;

class Student extends Human {
    private String university;
    private String faculty;
    private String specialty;


    public Student(String lastName, String firstName, String middleName, int age, Gender gender,
                   String university, String faculty, String specialty) {
        super(lastName, firstName, middleName, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
    }

    public Student(String lastName, String firstName, int age, Gender gender,
                   String university, String faculty, String specialty) {
        this(lastName, firstName, null, age, gender, university, faculty, specialty);
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Student student = (Student) object;
        return Objects.equals(university, student.university) && Objects.equals(faculty, student.faculty) && Objects.equals(specialty, student.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, faculty, specialty);
    }
}
