package com.example.accountservice.common.dto;

import lombok.Builder;

@Builder
public record CreditAccountRequest(
        String currency,
        double amount
) {
}
