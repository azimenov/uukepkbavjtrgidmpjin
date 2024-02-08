package com.example.uukepkbavjtrgidmpjin.salesman.controller;

import com.example.uukepkbavjtrgidmpjin.customer.dto.CustomerRequest;
import com.example.uukepkbavjtrgidmpjin.customer.dto.CustomerResponse;
import com.example.uukepkbavjtrgidmpjin.customer.filter.Filter;
import com.example.uukepkbavjtrgidmpjin.customer.model.Customer;
import com.example.uukepkbavjtrgidmpjin.salesman.dto.SalesmanRequest;
import com.example.uukepkbavjtrgidmpjin.salesman.dto.SalesmanResponse;
import com.example.uukepkbavjtrgidmpjin.salesman.model.Salesman;
import com.example.uukepkbavjtrgidmpjin.salesman.service.SalesmanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/salesman")
@RestController
@AllArgsConstructor
public class SalesmanController {
    private final SalesmanService salesmanService;
    @PostMapping("/createSalesman")
    public ResponseEntity<SalesmanResponse> createCustomer(@RequestBody SalesmanRequest salesmanRequest) {
        return salesmanService.createSalesman(salesmanRequest);
    }

    @DeleteMapping("/deleteSalesmanById")
    public ResponseEntity<SalesmanResponse> deleteSalesman(@RequestParam int id) {
        return salesmanService.deleteById(id);
    }

    @GetMapping("/getSalesmanById")
    public ResponseEntity<SalesmanResponse> getSalesman(@RequestParam int id) {
        return salesmanService.getById(id);
    }

    @GetMapping("/getByFilter")
    public List<Salesman> getSalesmans(@RequestBody Filter filter) {
        return salesmanService.getSalesmanWithFilter(filter.getOffset(), filter.getLimit());
    }

    @PatchMapping("/updateSalesman/{salesmanId}")
    public ResponseEntity<SalesmanResponse> updateSalesman(@RequestBody SalesmanRequest salesmanRequest, @PathVariable String salesmanId) {
        return salesmanService.updateSalesman(salesmanRequest, salesmanId);
    }
}
