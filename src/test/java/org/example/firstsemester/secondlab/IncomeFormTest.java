package org.example.firstsemester.secondlab;

import org.example.firstsemester.secondlab.IncomeForm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncomeFormTest {

    @Test
    void testIncomeFormInitialization() {
        double[] amounts = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000};
        IncomeForm form = new IncomeForm(2023, "Mark Rider", "Company A", amounts);

        assertEquals(2023, form.year(), "Year initialization failed");
        assertEquals("Mark Rider", form.fullName(), "FullName initialization failed");
        assertEquals("Company A", form.org(), "Org initialization failed");
        assertArrayEquals(amounts, form.amounts(), "Amounts array initialization failed");
    }

    @Test
    void testAmountsImmutability() {
        double[] originalAmounts = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000};
        IncomeForm form = new IncomeForm(2023, "Miron Moskalenko", "Company B", originalAmounts);

        originalAmounts[0] = 9999;

        assertNotEquals(originalAmounts[0], form.amounts()[0], "Amounts array should be immutable");
    }
}
