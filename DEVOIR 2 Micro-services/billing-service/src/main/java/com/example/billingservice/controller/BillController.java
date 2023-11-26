package com.example.billingservice.controller;
import com.example.billingservice.entities.Bill;
import com.example.billingservice.repository.BillRepository;
import com.example.billingservice.services.CustomerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bill")
public class BillController {
    private final BillRepository billRepository;
    private final CustomerClient customerClient;
    @GetMapping("/")
    public ResponseEntity<List<Bill>> getAll(){
        List<Bill> bills = billRepository.findAll();
        bills.forEach(bill -> {
            bill.setCustomer(customerClient.getCustomerById(bill.getCustomerID()));
        });
        return ResponseEntity.ok(bills);
    }
    @PostMapping("/")
    public ResponseEntity<Bill> save(@RequestBody Bill bill){
        System.out.println(bill);
        return ResponseEntity.ok(billRepository.save(bill));
    }
}
