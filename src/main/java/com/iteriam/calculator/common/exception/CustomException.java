package com.iteriam.calculator.common.exception;

public class CustomException extends Exception {

    public CustomException() {
        super("Internal error");
    }

    public CustomException(String message) {
        super(message);
    }
}
