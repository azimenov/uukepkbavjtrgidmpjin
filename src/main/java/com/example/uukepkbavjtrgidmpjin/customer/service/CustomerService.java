package com.example.uukepkbavjtrgidmpjin.customer.service;

import com.example.uukepkbavjtrgidmpjin.customer.dto.CustomerRequest;
import com.example.uukepkbavjtrgidmpjin.customer.dto.CustomerResponse;
import com.example.uukepkbavjtrgidmpjin.customer.filter.Filter;
import com.example.uukepkbavjtrgidmpjin.customer.model.Customer;
import com.example.uukepkbavjtrgidmpjin.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .username(customerRequest.getUsername())
                .firstPhoneNumber(customerRequest.getFirstPhoneNumber())
                .secondPhoneNumber(customerRequest.getSecondPhoneNumber())
                .year(customerRequest.getYear())
                .createdAt(LocalDateTime.now())
                .build();
        CustomerResponse customerResponse = CustomerResponse.builder()
                .username(customerRequest.getUsername())
                .firstPhoneNumber(customerRequest.getFirstPhoneNumber())
                .secondPhoneNumber(customerRequest.getSecondPhoneNumber())
                .year(customerRequest.getYear())
                .build();
        customerRepository.save(customer);

        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

    public ResponseEntity<CustomerResponse> deleteById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customerRepository.deleteById(id);
        if (customer.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(CustomerResponse.builder()
                    .username(customer.get().getUsername())
                    .firstPhoneNumber(customer.get().getFirstPhoneNumber())
                    .secondPhoneNumber(customer.get().getSecondPhoneNumber())
                    .year(customer.get().getYear())
                    .build());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<CustomerResponse> getById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(CustomerResponse.builder()
                    .username(customer.get().getUsername())
                    .firstPhoneNumber(customer.get().getFirstPhoneNumber())
                    .secondPhoneNumber(customer.get().getSecondPhoneNumber())
                    .year(customer.get().getYear())
                    .build());
        }
        return ResponseEntity.notFound().build();
    }


    public List<Customer> getCustomersWithFilter(Filter filter) {
        return customerRepository.findWithLimitAndOffset(filter.getOffset(), filter.getLimit());
    }

    public ResponseEntity<CustomerResponse> updateCustomer(CustomerRequest customerRequest, String customerId) {
        Integer.parseInt(customerId);
        if (customerRepository.existsById(Integer.valueOf(customerId))) {
            Customer existingCustomer = customerRepository.getById(Integer.valueOf(customerId));

            copy(customerRequest, existingCustomer);

            Customer savedCustomer = customerRepository.save(existingCustomer);

            return ResponseEntity.ok(CustomerResponse.builder()
                    .username(savedCustomer.getUsername())
                    .year(savedCustomer.getYear())
                    .firstPhoneNumber(savedCustomer.getFirstPhoneNumber())
                    .secondPhoneNumber(savedCustomer.getSecondPhoneNumber())
                    .build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void copy(CustomerRequest customerRequest, Customer customer){
        if(customerRequest.getUsername() != null){
            customer.setUsername(customerRequest.getUsername());
        }
        if(customerRequest.getFirstPhoneNumber() != null){
            customer.setFirstPhoneNumber(customerRequest.getFirstPhoneNumber());
        }
        if(customerRequest.getSecondPhoneNumber() != null){
            customer.setSecondPhoneNumber(customerRequest.getSecondPhoneNumber());
        }
        if(customerRequest.getYear() != 0){
            customer.setYear(customerRequest.getYear());
        }
    }
}
