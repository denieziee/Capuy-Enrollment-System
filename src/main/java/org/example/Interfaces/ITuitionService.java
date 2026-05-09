package org.example.Interfaces;

import org.example.Entities.Course;
import org.example.Entities.TuitionFeePayment;
import org.example.Exceptions.InvalidPaymentAmountException;

import java.util.List;

public interface ITuitionService {
    double calculateTotalFee(List<Course> courses);
    void makePayment(TuitionFeePayment paymentRecord, double amount) throws InvalidPaymentAmountException;
    void displayPaymentStatus(TuitionFeePayment paymentRecord);
}