package com.example.billingservice.entities;
import jakarta.persistence.*;

@Entity
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long ProductId;
}
