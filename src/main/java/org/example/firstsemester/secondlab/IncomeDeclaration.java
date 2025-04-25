package org.example.firstsemester.secondlab;

import java.util.Arrays;

public class IncomeDeclaration {
    private static final int monthsAmount = 12;
    private static final double lowIncome = 24000;
    private static final double highIncome = 240000;
    private static final double lowTax = 0.13;
    private static final double highTax = 0.20;
    private final int year;
    private final String fullName;
    private final double[] income = new double[monthsAmount];
    private final double[] totalIncome = new double[monthsAmount];
    private final double[] taxes = new double[monthsAmount];
    private final double totalTax;


    public  IncomeDeclaration(int year, String fullName, IncomeForm[] forms){
        this.year = year;
        this.fullName = fullName;
        for(int month = 0; month < monthsAmount; month++){
            for(IncomeForm form: forms){
                income[month] += form.amounts()[month];
            }
            if (month == 0) {
                totalIncome[month] = income[0];
            } else {
                totalIncome[month] = income[month] + totalIncome[month - 1];
            }
            if (month == 0) {
                taxes[month] = calculateTax(0, income[month], income[month]);
            } else {
                taxes[month] = calculateTax(totalIncome[month - 1], totalIncome[month], income[month]);
            }
        }
        this.totalTax = Arrays.stream(this.taxes).sum();
    }


    private static double calculateTax(double prevTotalIncome, double currTotalIncome, double nextIncome){
        if(currTotalIncome <= lowIncome){
            return 0;
        }
        if (currTotalIncome <= highIncome) {
            if (prevTotalIncome <= lowIncome) {
                return (currTotalIncome - lowIncome) * lowTax;
            } else {
                return nextIncome * lowTax;
            }
        } else {
            if (prevTotalIncome <= highIncome) {
                return (highIncome - prevTotalIncome) * lowTax + (currTotalIncome - highIncome) * highTax;
            } else {
                return nextIncome * highTax;
            }
        }
    }
    public int getYear() {
        return year;
    }

    public String getFullName() {
        return fullName;
    }

    public double[] getIncome() {
        return income;
    }

    public double[] getTotalIncome() {
        return totalIncome;
    }

    public double[] getTaxes() {
        return taxes;
    }

    public double getTotalTax() {
        return totalTax;
    }
}
