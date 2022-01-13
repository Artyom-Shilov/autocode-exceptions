package com.epam.tat.exceptions.exception;

public class InitializationException extends RuntimeException {

    public InitializationException() {
        super();
    }

    public InitializationException(String message) {
        super(message);
    }

    public InitializationException(Throwable cause) {
        super(cause);
    }

    public InitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
