package org.example.Implementations;

import org.example.Entities.Course;
import org.example.Entities.Student;
import org.example.Entities.TuitionFeePayment;
import org.example.Exceptions.InvalidPaymentAmountException;
import org.example.Interfaces.ITuitionService;
import java.util.List;

public class TuitionServiceImpl implements ITuitionService {
    private final double RATE_PER_COURSE = 1500.00;

    @Override
    public double calculateTotalFee(List<Course> courses) {
        if (courses == null) return 0.0;
        return courses.size() * RATE_PER_COURSE;
    }

    @Override
    public void makePayment(TuitionFeePayment record, double amount) throws InvalidPaymentAmountException {
        if (amount <= 0) {
            throw new InvalidPaymentAmountException("Payment amount must be greater than zero.");
        }
        double currentBalance = record.getRemainingBalance();

        if (amount > currentBalance) {
            throw new InvalidPaymentAmountException("Payment exceeds the remaining balance of " + currentBalance);
        }

        double newBalance = currentBalance - amount;
        record.setRemainingBalance(newBalance);
        System.out.println("Success: Payment of " + amount + " processed.");
    }

    @Override
    public void displayPaymentStatus(TuitionFeePayment paymentRecord) {
        System.out.println(paymentRecord.toString());
        if (paymentRecord.getRemainingBalance() <= 0) {
            System.out.println("Status: FULLY PAID");
        } else {
            System.out.println("Status: PENDING BALANCE (" + paymentRecord.getRemainingBalance() + ")");
        }
    }
}