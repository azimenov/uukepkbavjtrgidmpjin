package com.example.uukepkbavjtrgidmpjin.salesman.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalesmanResponse {
    private String username;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private int year;
}
