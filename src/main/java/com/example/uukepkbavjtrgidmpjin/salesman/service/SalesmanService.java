package com.example.uukepkbavjtrgidmpjin.salesman.service;

import com.example.uukepkbavjtrgidmpjin.customer.filter.Filter;
import com.example.uukepkbavjtrgidmpjin.salesman.dto.SalesmanRequest;
import com.example.uukepkbavjtrgidmpjin.salesman.dto.SalesmanResponse;
import com.example.uukepkbavjtrgidmpjin.salesman.model.Salesman;
import com.example.uukepkbavjtrgidmpjin.salesman.repository.SalesmanRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalesmanService {
    private final SalesmanRepository salesmanRepository;

    public ResponseEntity<SalesmanResponse> createSalesman(SalesmanRequest customerRequest) {
        Salesman customer = Salesman.builder()
                .username(customerRequest.getUsername())
                .firstPhoneNumber(customerRequest.getFirstPhoneNumber())
                .secondPhoneNumber(customerRequest.getSecondPhoneNumber())
                .year(customerRequest.getYear())
                .createdAt(LocalDateTime.now())
                .build();
        SalesmanResponse salesmanResponse = SalesmanResponse.builder()
                .username(customerRequest.getUsername())
                .firstPhoneNumber(customerRequest.getFirstPhoneNumber())
                .secondPhoneNumber(customerRequest.getSecondPhoneNumber())
                .year(customerRequest.getYear())
                .build();
        salesmanRepository.save(customer);

        return new ResponseEntity<>(salesmanResponse, HttpStatus.CREATED);
    }

    public ResponseEntity<SalesmanResponse> deleteById(int id) {
        Optional<Salesman> salesman = salesmanRepository.findById(id);
        salesmanRepository.deleteById(id);
        if (salesman.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(SalesmanResponse.builder()
                    .username(salesman.get().getUsername())
                    .firstPhoneNumber(salesman.get().getFirstPhoneNumber())
                    .secondPhoneNumber(salesman.get().getSecondPhoneNumber())
                    .year(salesman.get().getYear())
                    .build());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<SalesmanResponse> getById(int id) {
        Optional<Salesman> salesman = salesmanRepository.findById(id);
        if (salesman.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(SalesmanResponse.builder()
                    .username(salesman.get().getUsername())
                    .firstPhoneNumber(salesman.get().getFirstPhoneNumber())
                    .secondPhoneNumber(salesman.get().getSecondPhoneNumber())
                    .year(salesman.get().getYear())
                    .build());
        }
        return ResponseEntity.notFound().build();
    }


    public List<Salesman> getSalesmanWithFilter(int offset, int limit) {
        Page<Salesman> page = salesmanRepository.findAll(
                PageRequest.of(offset, limit, Sort.Direction.ASC, "salesman_id"));
        List<Salesman> customers = page.getContent();

        return Collections.unmodifiableList(customers);
    }

    public ResponseEntity<SalesmanResponse> updateSalesman(SalesmanRequest customerRequest, int customerId) {
        Integer.parseInt(customerId);
        if (salesmanRepository.existsById(Integer.valueOf(customerId))) {
            Optional<Salesman> existingSalesman = salesmanRepository.findById(Integer.valueOf(customerId));

            copy(customerRequest, existingSalesman.get());

            Salesman savedSalesman = salesmanRepository.save(existingSalesman.get());

            return ResponseEntity.ok(SalesmanResponse.builder()
                    .username(savedSalesman.getUsername())
                    .year(savedSalesman.getYear())
                    .firstPhoneNumber(savedSalesman.getFirstPhoneNumber())
                    .secondPhoneNumber(savedSalesman.getSecondPhoneNumber())
                    .build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void copy(SalesmanRequest salesmanRequest, Salesman salesman){
        if(salesmanRequest.getUsername() != null){
            salesman.setUsername(salesmanRequest.getUsername());
        }
        if(salesmanRequest.getFirstPhoneNumber() != null){
            salesman.setFirstPhoneNumber(salesmanRequest.getFirstPhoneNumber());
        }
        if(salesmanRequest.getSecondPhoneNumber() != null){
            salesman.setSecondPhoneNumber(salesmanRequest.getSecondPhoneNumber());
        }
        if(salesmanRequest.getYear() != 0){
            salesman.setYear(salesmanRequest.getYear());
        }
    }
}
