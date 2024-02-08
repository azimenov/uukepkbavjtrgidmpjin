package com.example.uukepkbavjtrgidmpjin.salesman.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Entity
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salesman {
    @Id
    private int salesman_id;
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


    private LocalDateTime createdAt;

}
