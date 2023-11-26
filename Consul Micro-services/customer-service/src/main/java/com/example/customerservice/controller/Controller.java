package com.example.customerservice.controller;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class Controller {
    private final CustomerRepository customerRepository;
    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerRepository.findAll());
    }
    @PostMapping("/")
    public ResponseEntity<String> addOne(){
        customerRepository.save(new Customer(null,"Ahmed","0651571989"));
        return ResponseEntity.ok("New customer is added");
    }
}
