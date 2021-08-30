package com.hackerrank.sample.exception;

public class StringResponseNotFoundException extends RuntimeException {

    public StringResponseNotFoundException(String exception) {
        super(exception);
    }
}
