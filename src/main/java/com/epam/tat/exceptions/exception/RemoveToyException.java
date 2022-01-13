package com.epam.tat.exceptions.exception;

public class RemoveToyException extends RuntimeException {

    public RemoveToyException() {
        super();
    }

    public RemoveToyException(String message) {
        super(message);
    }

    public RemoveToyException(Throwable cause) {
        super(cause);
    }

    public RemoveToyException(String message, Throwable cause) {
        super(message, cause);
    }
}
