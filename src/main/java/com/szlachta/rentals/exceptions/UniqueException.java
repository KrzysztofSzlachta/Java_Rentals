package com.szlachta.rentals.exceptions;

public class UniqueException extends RuntimeException {
    public UniqueException(String message) {
        super(message);
    }
}
