package com.example.uukepkbavjtrgidmpjin.customer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(min = 5)
    private String username;

    private int year;
    @NotBlank
    @Pattern(regexp = "\\+7\\d{10}")
    private String firstPhoneNumber;
    @NotBlank
    @Pattern(regexp = "\\+7\\d{10}")
    private String secondPhoneNumber;


    @Column(updatable = false)
    private LocalDateTime createdAt;

}
