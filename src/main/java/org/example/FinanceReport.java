package org.example;

public class FinanceReport {
    private Payment[] payments;
    private String creatorFullname;
    private int day;
    private int month;
    private int year;

    public FinanceReport (Payment[] payments, String creatorFullname, int day, int month, int year){
        this.payments = payments;
        this.creatorFullname = creatorFullname;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public FinanceReport (FinanceReport report){
        payments = report.payments.clone();
        creatorFullname = report.creatorFullname;
        day = report.day;
        month = report.month;
        year = report.year;
    }

}
