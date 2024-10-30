package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncomeDeclarationTest {

    @Test
    void testIncomeDeclarationCalculations() {
        double[] amounts1 = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000};
        double[] amounts2 = {2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000, 13000};
        IncomeForm form1 = new IncomeForm(2023, "Mark Rider", "Company A", amounts1);
        IncomeForm form2 = new IncomeForm(2023, "Miron Moskalenko", "Company B", amounts2);
        IncomeDeclaration declaration = new IncomeDeclaration(2023, "John Doe", new IncomeForm[]{form1, form2});

        // Check if income for each month is calculated correctly
        double[] expectedIncome = new double[12];
        for (int i = 0; i < expectedIncome.length; i++) {
            expectedIncome[i] = amounts1[i] + amounts2[i];
        }
        assertArrayEquals(expectedIncome, declaration.getIncome(), "Monthly income calculation failed");

        // Check if total income accumulates correctly
        double[] expectedTotalIncome = new double[12];
        expectedTotalIncome[0] = expectedIncome[0];
        for (int i = 1; i < expectedTotalIncome.length; i++) {
            expectedTotalIncome[i] = expectedTotalIncome[i - 1] + expectedIncome[i];
        }
        assertArrayEquals(expectedTotalIncome, declaration.getTotalIncome(), "Total income calculation failed");

        // Validate taxes are calculated correctly
        double[] taxes = declaration.getTaxes();
        assertNotNull(taxes, "Taxes array should not be null");

        // Check if total tax is calculated correctly
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
}
