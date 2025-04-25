package org.example.firstsemester.secondlab;

import org.example.firstsemester.secondlab.IncomeDeclaration;
import org.example.firstsemester.secondlab.IncomeForm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncomeDeclarationTest {

    @Test
    void testIncomeDeclarationCalculations() {
        double[] amounts1 = {1200,2300,24000,25000,1000,1000,1000,1000,1000,1000,1000,1000};
        double[] amounts2 = {6,6,8,60,1000,1000,1000,1000,1000,1000,1000,1000};
        IncomeForm form1 = new IncomeForm(2023, "Mark Rider", "Company A", amounts1);
        IncomeForm form2 = new IncomeForm(2023, "Miron Moskalenko", "Company B", amounts2);
        IncomeDeclaration declaration = new IncomeDeclaration(2023, "John Doe", new IncomeForm[]{form1, form2});


        double[] expectedIncome = new double[12];
        for (int i = 0; i < expectedIncome.length; i++) {
            expectedIncome[i] = amounts1[i] + amounts2[i];
        }
        assertArrayEquals(expectedIncome, declaration.getIncome(), "Monthly income calculation failed");

        double[] expectedTotalIncome = new double[12];
        expectedTotalIncome[0] = expectedIncome[0];
        for (int i = 1; i < expectedTotalIncome.length; i++) {
            expectedTotalIncome[i] = expectedTotalIncome[i - 1] + expectedIncome[i];
        }
        assertArrayEquals(expectedTotalIncome, declaration.getTotalIncome(), "Total income calculation failed");

        double[] taxes = declaration.getTaxes();
        assertNotNull(taxes, "Taxes array should not be null");

        double totalTax = declaration.getTotalTax();
        double calculatedTotalTax = 0;
        for (double tax : taxes) {
            calculatedTotalTax += tax;
        }
        assertEquals(calculatedTotalTax, totalTax, "Total tax calculation mismatch");
    }

    @Test
    void testGetters() {
        IncomeDeclaration declaration = new IncomeDeclaration(2023, "Pasha Fizik", new IncomeForm[]{
                new IncomeForm(2023, "Pasha Fizik", "Company C", new double[12])
        });

        assertEquals(2023, declaration.getYear(), "Year getter failed");
        assertEquals("Pasha Fizik", declaration.getFullName(), "FullName getter failed");
        assertEquals(12, declaration.getIncome().length, "Income array length should be 12");
        assertEquals(12, declaration.getTotalIncome().length, "TotalIncome array length should be 12");
        assertEquals(12, declaration.getTaxes().length, "Taxes array length should be 12");
    }

    @Test
    void testTaxCalculationThresholds() {

        double[] lowIncomeAmounts = {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
        IncomeForm formLowIncome = new IncomeForm(2023, "Alice", "Company A", lowIncomeAmounts);
        IncomeDeclaration declarationLowIncome = new IncomeDeclaration(2023, "Alice", new IncomeForm[]{formLowIncome});
        assertEquals(0, declarationLowIncome.getTotalTax(), "Tax should be 0 for income <= 24,000");

        double[] midIncomeAmounts = {20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000};
        IncomeForm formMidIncome = new IncomeForm(2023, "Bob", "Company B", midIncomeAmounts);
        IncomeDeclaration declarationMidIncome = new IncomeDeclaration(2023, "Bob", new IncomeForm[]{formMidIncome});
        double expectedMidIncomeTax = (240000 - 24000) * 0.13;
        assertEquals(expectedMidIncomeTax, declarationMidIncome.getTotalTax(), 0.01, "Tax should be 13% on income between 24,000 and 240,000");

        double[] highIncomeAmounts = {30000, 30000, 30000, 30000, 30000, 30000, 30000, 30000, 30000, 30000, 30000, 30000};
        IncomeForm formHighIncome = new IncomeForm(2023, "Charlie", "Company C", highIncomeAmounts);
        IncomeDeclaration declarationHighIncome = new IncomeDeclaration(2023, "Charlie", new IncomeForm[]{formHighIncome});
        double expectedHighIncomeTax = (240000 - 24000) * 0.13 + (360000 - 240000) * 0.20;
        assertEquals(expectedHighIncomeTax, declarationHighIncome.getTotalTax(), 0.01, "Tax should be 13% on income up to 240,000 and 20% on income above 240,000");
    }
}
