package com.xyz.portal.controller;

import com.xyz.portal.entity.Customer;
import com.xyz.portal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerList);
    }
}