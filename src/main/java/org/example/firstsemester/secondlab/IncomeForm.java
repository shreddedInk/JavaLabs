package org.example.firstsemester.secondlab;

import java.util.Arrays;

public record IncomeForm(int year, String fullName, String org, double[] amounts) {
    public IncomeForm(int year, String fullName, String org, double[] amounts){
        this.year = year;
        this.fullName = fullName;
        this.org = org;
        this.amounts = Arrays.copyOf(amounts, 12);
    }
}
