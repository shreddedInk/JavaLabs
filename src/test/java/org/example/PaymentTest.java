package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    public void testGettersAndSetters() {
        Payment payment = new Payment("Mark Rider", 15, 10, 1999, 500);

        assertEquals("Mark Rider", payment.getFullName());
        assertEquals(15, payment.getDay());
        assertEquals(10, payment.getMonth());
        assertEquals(1999, payment.getYear());
        assertEquals(500, payment.getAmount());

        payment.setFullName("Miron Moskalenko");
        payment.setDay(28);
        payment.setMonth(11);
        payment.setYear(2024);
        payment.setAmount(600);

        assertEquals("Miron Moskalenko", payment.getFullName());
        assertEquals(28, payment.getDay());
        assertEquals(11, payment.getMonth());
        assertEquals(2024, payment.getYear());
        assertEquals(600, payment.getAmount());
    }

    @Test
    public void testEqualsAndHashCode() {
        Payment payment1 = new Payment("Petya", 15, 10, 2023, 500);
        Payment payment2 = new Payment("Petya", 15, 10, 2023, 500);
        Payment payment3 = new Payment("Petya", 16, 11, 2024, 600);

        assertEquals(payment1, payment2);
        assertNotEquals(payment1, payment3);

        assertEquals(payment1.hashCode(), payment2.hashCode());
        assertNotEquals(payment1.hashCode(), payment3.hashCode());
    }

    @Test
    public void testToString() {
        Payment payment = new Payment("Demidovich", 15, 10, 2023, 500);
        String expected = "Payment{fullname='Demidovich', day=15, month=10, year=2023, amount=500}";
        assertEquals(expected, payment.toString());
    }
}
