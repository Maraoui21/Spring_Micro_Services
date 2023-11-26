package com.example.billingservice.services;

import com.example.billingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "customer",url = "${application.config.customer-url}")
public interface CustomerClient {
    @GetMapping("/{customerId}")
    Customer getCustomerById(@PathVariable("customerId") Long customerId);
}
