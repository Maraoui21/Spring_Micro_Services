package com.example.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.billingservice.entities.Bill;
public interface BillRepository extends JpaRepository<Bill,Long> {
}
