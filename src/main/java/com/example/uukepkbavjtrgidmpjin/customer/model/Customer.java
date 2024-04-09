package com.example.uukepkbavjtrgidmpjin.customer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    private String username;

    private int year;

    private String firstPhoneNumber;

    private String secondPhoneNumber;

    @Column(updatable = false)
    private LocalDateTime createdAt;

}
