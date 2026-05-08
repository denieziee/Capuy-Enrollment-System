package org.example.Implementations;

import org.example.Interfaces.ITuitionService;
import org.example.Entities.Course;
import org.example.Entities.TuitionFeePayment;
import java.util.List;

public class TuitionServiceImpl implements ITuitionService {

    private static final double RATE_PER_COURSE = 1000.00;

    @Override
    public double calculateTotalFee(List<Course> courses) {
        if (courses == null) return 0.0;
        return courses.size() * RATE_PER_COURSE;
    }

    @Override
    public void makePayment(TuitionFeePayment record, double amount) {
        if (amount <= 0) {
            System.out.println("Error: Payment amount must be greater than zero.");
            return;
        }

        double currentBalance = record.getRemainingBalance();
        double newBalance = currentBalance - amount;

        // it doesn't go below 0
        if (newBalance < 0) {
            newBalance = 0;
        }

        record.setRemainingBalance(newBalance);
        System.out.println("Payment processed: " + amount);
    }

    @Override
    public void displayPaymentStatus(TuitionFeePayment paymentRecord) {
        System.out.println(paymentRecord.toString());
        if (paymentRecord.getRemainingBalance() <= 0) {
            System.out.println("Status: FULLY PAID");
        } else {
            System.out.println("Status: PENDING BALANCE");
        }
    }
}