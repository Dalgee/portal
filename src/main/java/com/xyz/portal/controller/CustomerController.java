package com.xyz.portal.controller;

import com.xyz.portal.domain.dto.CustomerDTO;
import com.xyz.portal.domain.entity.Customer;
import com.xyz.portal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "customerId") final long customerId) {
        Customer customer = customerService.getCustomer(customerId);


        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customer);
    }


    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody final CustomerDTO customerDTO) {
        long customerId = customerService.createCustomer(customerDTO).getCustomerId();

        Customer customer = customerService.sendVerifyEmail(customerId);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customer);
    }


    @GetMapping("/{customerId}/verifyEmail/{uuid}")
    public ResponseEntity<Customer> verifyEmail(@PathVariable(value="customerId") final long customerId,
                                                @PathVariable(value="uuid") final String uuid) {
        Customer customer =  customerService.verifyEmail(customerId, uuid);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customer);
    }


    @GetMapping("/{customerId}/verifyEmail/send")
    public ResponseEntity<Customer> sendVerifyEmail(@PathVariable(value="customerId") final long customerId) {
        Customer customer = customerService.sendVerifyEmail(customerId);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customer);
    }
}
