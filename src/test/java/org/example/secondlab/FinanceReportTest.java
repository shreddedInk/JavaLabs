package org.example.secondlab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinanceReportTest {
    Payment[] payments = {
            new Payment("Miron Moskalenko", 10, 10, 2023, 10000),
            new Payment("Vyacheslav Markov", 12, 10, 2023, 20050)
    };
    FinanceReport report = new FinanceReport(payments, "Mark Rider", 13, 10, 2023);
    Payment newPayment = new Payment("Alan Ibraev", 15, 10, 2023, 30500);


    @Test
    public void testConstructorAndGetters() {
        assertEquals("Mark Rider", report.getCreatorFullname());
        assertEquals(2, report.getPaymentCount());
        assertEquals(13, report.getDay());
        assertEquals(10, report.getMonth());
        assertEquals(2023, report.getYear());
    }

    @Test
    public void testGetPaymentValidIndex() {
        Payment payment = report.getPayment(1);
        assertEquals("Vyacheslav Markov", payment.getFullName());
        assertEquals(20050, payment.getAmount());
    }

    @Test
    public void testGetPaymentInvalidIndex() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            report.getPayment(5);
        });

        assertEquals("Неправильный индекс платежа", exception.getMessage());
    }

    @Test
    public void testSetPaymentValidIndex() {
        report.setPayment(1, newPayment);
        assertEquals("Alan Ibraev", report.getPayment(1).getFullName());
        assertEquals(30500, report.getPayment(1).getAmount());
    }

    @Test
    public void testSetPaymentInvalidIndex() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            report.setPayment(3, newPayment);  // invalid index
        });

        assertEquals("Неправильный индекс платежа", exception.getMessage());
    }

    @Test
    public void testToString() {
        String expected = "[Автор: Mark Rider, дата: 13.10.2023, Платежи: [\n" +
                "\t Плательщик: Miron Moskalenko , дата: 10.10.2023 сумма: 100 руб. 00 коп. \n" +
                "\t Плательщик: Vyacheslav Markov , дата: 12.10.2023 сумма: 200 руб. 50 коп. ]]";

        assertEquals(expected, report.toString());
    }

}
