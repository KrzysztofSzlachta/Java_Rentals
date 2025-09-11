package com.szlachta.rentals.exceptions;

public class InUseException extends RuntimeException {
    public InUseException(String message) {
        super(message);
    }
}
