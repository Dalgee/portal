package com.xyz.portal.exception;

public class EmailAlreadyVerifiedException extends RuntimeException {

    public EmailAlreadyVerifiedException() {

    }

    public EmailAlreadyVerifiedException(String message) {
        super(message);
    }
}
