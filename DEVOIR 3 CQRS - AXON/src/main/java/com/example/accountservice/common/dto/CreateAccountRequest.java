package com.example.accountservice.common.dto;

import lombok.Builder;

@Builder
public record CreateAccountRequest(
        String currency,
        double startingBalance
) {
}
