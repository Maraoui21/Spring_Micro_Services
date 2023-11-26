package com.example.inventoryservice.controller;

import com.example.inventoryservice.Repository.InventoryRepository;
import com.example.inventoryservice.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryRepository inventoryRepository;
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(inventoryRepository.findAll());
    }
    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(inventoryRepository.save(product));
    }
}
