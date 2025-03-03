package org.example.secondsemester.sixthlab;

public class Student extends Human{
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student(String surname, String name, String patronymic, int age, String department){
        super(surname, name, patronymic, age);
        this.department = department;
    }
}
