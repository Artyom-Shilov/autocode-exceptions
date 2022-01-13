package com.epam.tat.exceptions.exception;

public class AddToyException extends RuntimeException {

    public AddToyException() {
        super();
    }

    public AddToyException(String message) {
        super(message);
    }

    public AddToyException(Throwable cause) {
        super(cause);
    }

    public AddToyException(String message, Throwable cause) {
        super(message, cause);
    }

}
