package com.example.accountservice.query.repository;

import com.example.accountservice.query.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, String> {
    List<AccountTransaction> findByAccountId(String accountId);
}

