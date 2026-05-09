package org.example.Exceptions;

public class InvalidIdFormatException extends Exception {
    public InvalidIdFormatException(String message) {
        super(message);
    }
}