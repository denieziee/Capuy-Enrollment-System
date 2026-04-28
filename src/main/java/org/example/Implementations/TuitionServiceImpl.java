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
    public void makePayment(TuitionFeePayment paymentRecord, double amount) {
        if (amount <= 0) {
            System.out.println("Error: Payment amount must be greater than zero.");
            return;
        }

        double currentPaid = paymentRecord.getBalancePaid();
        double newPaidTotal = currentPaid + amount;

        paymentRecord.setBalancePaid(newPaidTotal);
        paymentRecord.setRemainingBalance(paymentRecord.getTotalTuition() - newPaidTotal);

        System.out.println("Payment processed: " + String.format("%.2f", amount));
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