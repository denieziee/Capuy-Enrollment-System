package org.example.Exceptions;

public class InvalidPaymentAmountException extends Exception {
    public InvalidPaymentAmountException(String message) {
        super(message);
    }
}
