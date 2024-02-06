package com.example.uukepkbavjtrgidmpjin.customer.dto;

import lombok.Data;

@Data
public class CustomerRequest {
    private String username;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private int year;
}
