package org.example.Exceptions;

public class DuplicateIdException extends Exception {
    public DuplicateIdException(String message) {
        super(message);
    }
}