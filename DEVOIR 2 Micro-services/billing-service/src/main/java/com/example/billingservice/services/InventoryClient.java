package com.example.billingservice.services;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "inventory",url = "${application.config.inventory-url}")
public interface InventoryClient {
}
