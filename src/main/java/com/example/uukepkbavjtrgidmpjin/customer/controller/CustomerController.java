package com.example.uukepkbavjtrgidmpjin.customer.controller;


import com.example.uukepkbavjtrgidmpjin.customer.dto.CustomerRequest;
import com.example.uukepkbavjtrgidmpjin.customer.dto.CustomerResponse;
import com.example.uukepkbavjtrgidmpjin.customer.filter.Filter;
import com.example.uukepkbavjtrgidmpjin.customer.model.Customer;
import com.example.uukepkbavjtrgidmpjin.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customer")
@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @DeleteMapping("/deleteCustomerById")
    public ResponseEntity<CustomerResponse> deleteCustomer(@RequestParam int id) {
        return customerService.deleteById(id);
    }

    @GetMapping("/getCustomerById")
    public ResponseEntity<CustomerResponse> getCustomer(@RequestParam int id) {
        return customerService.getById(id);
    }

    @GetMapping("/getCustomerByFilter")
    public List<Customer> getCustomers(@RequestBody Filter filter) {
        return customerService.getCustomersWithFilter(filter);
    }

    @PatchMapping("/updateCustomer/{customerId}")
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable String customerId) {
        return customerService.updateCustomer(customerRequest, customerId);
    }
}
