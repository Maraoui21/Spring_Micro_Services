package com.example.accountservice.common.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String e) {
        super(e);
    }
}
