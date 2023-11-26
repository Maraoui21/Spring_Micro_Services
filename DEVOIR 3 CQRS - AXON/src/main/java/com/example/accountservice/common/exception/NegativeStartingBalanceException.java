package com.example.accountservice.common.exception;

public class NegativeStartingBalanceException extends RuntimeException {
    public NegativeStartingBalanceException(String e) {
        super(e);
    }
}
