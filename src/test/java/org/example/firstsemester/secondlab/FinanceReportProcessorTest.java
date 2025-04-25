package org.example.firstsemester.secondlab;

import org.example.firstsemester.secondlab.FinanceReport;
import org.example.firstsemester.secondlab.FinanceReportProcessor;
import org.example.firstsemester.secondlab.Payment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinanceReportProcessorTest {

    @Test
    public void testFilterPaymentsByName_withMatchingLetter() {
        Payment[] payments = {
                new Payment("Mark Rider", 12, 6, 2023, 300),
                new Payment("Miron Moskalenko", 15, 7, 2023, 400),
                new Payment("Petya", 18, 8, 2023, 500),
                new Payment("Masha", 25, 9, 2023, 600)
        };
        FinanceReport report = new FinanceReport(payments, "John Doe", 30, 10, 2023);

        FinanceReport result = FinanceReportProcessor.filterPaymentsByName(report, 'M');

        assertEquals(3, result.getPayments().length);
        assertEquals("Mark Rider", result.getPayments()[0].getFullName());
        assertEquals("Miron Moskalenko", result.getPayments()[1].getFullName());
        assertEquals("Masha", result.getPayments()[2].getFullName());
    }

    @Test
    public void testFilterPaymentsByName_withNoMatchingLetter() {
        Payment[] payments = {
                new Payment("Mark Rider", 12, 6, 2023, 300),
                new Payment("Miron Moskalenko", 15, 7, 2023, 400),
                new Payment("Petya", 18, 8, 2023, 500),
                new Payment("Masha", 25, 9, 2023, 600)
        };
        FinanceReport report = new FinanceReport(payments, "John Doe", 30, 10, 2023);

        FinanceReport result = FinanceReportProcessor.filterPaymentsByName(report, 'Z');

        assertEquals(0, result.getPayments().length);
    }

    @Test
    public void testFilterPaymentsByName_caseInsensitive() {
        Payment[] payments = {
                new Payment("mark rider", 12, 6, 2023, 300),
                new Payment("Miron Moskalenko", 15, 7, 2023, 400),
                new Payment("petya", 18, 8, 2023, 500),
                new Payment("Masha", 25, 9, 2023, 600)
        };
        FinanceReport report = new FinanceReport(payments, "John Doe", 30, 10, 2023);

        FinanceReport result = FinanceReportProcessor.filterPaymentsByName(report, 'm');

        assertEquals(3, result.getPayments().length);
        assertEquals("mark rider", result.getPayments()[0].getFullName());
        assertEquals("Miron Moskalenko", result.getPayments()[1].getFullName());
        assertEquals("Masha", result.getPayments()[2].getFullName());
    }

    @Test
    public void testFilterPaymentsByName_emptyPayments() {
        Payment[] payments = {};
        FinanceReport report = new FinanceReport(payments, "John Doe", 30, 10, 2023);

        FinanceReport result = FinanceReportProcessor.filterPaymentsByName(report, 'M');

        assertEquals(0, result.getPayments().length);
    }
}
