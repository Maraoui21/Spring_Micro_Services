package com.example.customerservice.controller;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;
    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerRepository.findAll());
    }
    @PostMapping("/")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerRepository.save(customer));
    }
    @GetMapping("/{CustomerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long CustomerId){
        return ResponseEntity.ok(
                customerRepository.findById(CustomerId).orElseThrow(RuntimeException::new)
        );
    }
}
