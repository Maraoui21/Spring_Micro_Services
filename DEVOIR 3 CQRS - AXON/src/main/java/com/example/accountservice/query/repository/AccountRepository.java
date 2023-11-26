package com.example.accountservice.query.repository;

import com.example.accountservice.query.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
