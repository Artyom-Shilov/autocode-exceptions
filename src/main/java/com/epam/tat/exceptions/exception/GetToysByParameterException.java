package com.epam.tat.exceptions.exception;

public class GetToysByParameterException extends RuntimeException {

    public GetToysByParameterException() {
        super();
    }

    public GetToysByParameterException(String message) {
        super(message);
    }

    public GetToysByParameterException(Throwable cause) {
        super(cause);
    }

    public GetToysByParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
