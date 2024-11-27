package org.example.secondlab;

public class FinanceReport {
    private Payment[] payments={};
    private String creatorFullname="";
    private int day=0;
    private int month=0;
    private int year=0;

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

    public String getCreatorFullname(){
        return creatorFullname;
    }

    public int getPaymentCount() {
        return payments.length;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public int getAmount(){
        return payments.length;
    }

    public Payment getPayment(int index){
        if (index < 0 || index >= payments.length){
            throw new IllegalArgumentException("Неправильный индекс платежа");
        }
        return payments[index];
    }

    public void setPayment(int index, Payment payment) {
        if (index < 0 || index >= payments.length) {
            throw new IllegalArgumentException("Неправильный индекс платежа");
        }
        payments[index] = payment;
    }

    @Override
    public String toString() {
        StringBuilder reportString = new StringBuilder("[Автор: ");
        reportString.append(getCreatorFullname());
        reportString.append(String.format(", дата: %d.%d.%d", day,month,year));
        reportString.append(", Платежи: [\n");
        int count = payments.length;
        for (Payment payment : payments) {
            if (payment != null) {
                int rubles = payment.getAmount() / 100;
                int kopecks = payment.getAmount() % 100;
                reportString.append(String.format("\t Плательщик: %s , дата: %02d.%02d.%04d сумма: %d руб. %02d коп. ",
                        payment.getFullName(), payment.getDay(), payment.getMonth(), payment.getYear(), rubles, kopecks));
                if (count > 1){
                    reportString.append("\n");
                    count--;
                }
            }
        }
        reportString.append("]]");
        return reportString.toString();
    }
}