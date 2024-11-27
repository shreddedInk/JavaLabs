package org.example.secondlab;

public class FinanceReportProcessor {

    public static FinanceReport filterPaymentsByName(FinanceReport report, char letter) {
        Payment[] originalPayments = report.getPayments();
        Payment[] filteredPayments = new Payment[originalPayments.length];
        int count = 0;

        for (Payment payment : originalPayments) {
            if (Character.toUpperCase(payment.getFullName().charAt(0)) == Character.toUpperCase(letter)) {
                filteredPayments[count] = payment;
                count++;
            }
        }

        Payment[] resultPayments = new Payment[count];
        System.arraycopy(filteredPayments, 0, resultPayments, 0, count);

        return new FinanceReport(
                resultPayments,
                report.getCreatorFullname(),
                report.getDay(),
                report.getMonth(),
                report.getYear()
        );
    }
}
