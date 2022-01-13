package com.epam.tat.exceptions.exception;

public class UpdateToyException extends RuntimeException  {

    public UpdateToyException() {
        super();
    }

    public UpdateToyException(String message) {
        super(message);
    }

    public UpdateToyException(Throwable cause) {
        super(cause);
    }

    public UpdateToyException(String message, Throwable cause) {
        super(message, cause);
    }
}
