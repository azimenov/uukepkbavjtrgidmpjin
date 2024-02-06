package com.example.uukepkbavjtrgidmpjin.customer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @Column(name = "contact_id")
    private int customerId;
    @NotBlank
    @Size(min = 5)
    private String username;
    @NotBlank
    private int year;
    @NotBlank
    @Pattern(regexp = "\\+7\\d{10}")
    private String firstPhoneNumber;
    @NotBlank
    @Pattern(regexp = "\\+7\\d{10}")
    private String secondPhoneNumber;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
