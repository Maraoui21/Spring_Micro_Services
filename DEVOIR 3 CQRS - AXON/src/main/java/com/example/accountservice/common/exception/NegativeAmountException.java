package com.example.accountservice.common.exception;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String e) {
        super(e);
    }
}
