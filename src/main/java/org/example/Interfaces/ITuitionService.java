package org.example.Interfaces;

import org.example.Entities.Course;
import org.example.Entities.TuitionFeePayment;
import java.util.List;

public interface ITuitionService {
    double calculateTotalFee(List<Course> courses);
    void makePayment(TuitionFeePayment paymentRecord, double amount);
    void displayPaymentStatus(TuitionFeePayment paymentRecord);
}