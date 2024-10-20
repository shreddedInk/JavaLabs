package org.example;

import java.util.Objects;

public class Payment {
    private String fullname;
    private int day;
    private int month;
    private int year;
    private int amount;

    public Payment(String fullname, int day, int month, int year, int amount){
        this.fullname=fullname;
        this.day=day;
        this.month=month;
        this.year=year;
        this.amount=amount;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullName) {
        this.fullname = fullName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, getDay(), getMonth(), getYear(), getAmount());
    };

    @Override
    public String toString() {
        return "Payment{" +
                "fullname='" + fullname + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", amount=" + amount +
                '}';
    }
}
