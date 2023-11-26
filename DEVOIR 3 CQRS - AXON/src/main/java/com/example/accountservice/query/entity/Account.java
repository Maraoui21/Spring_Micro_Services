package com.example.accountservice.query.entity;

import com.example.accountservice.common.enums.AccountStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String id;
    private String currency;
    private double balance;
    private Instant createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<AccountTransaction> transactions;
}
