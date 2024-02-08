package com.example.uukepkbavjtrgidmpjin;

import com.example.uukepkbavjtrgidmpjin.customer.repository.CustomerRepository;
import com.example.uukepkbavjtrgidmpjin.salesman.repository.SalesmanRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class UukepkbavjtrgidmpjinApplication {

    public static void main(String[] args) {
        SpringApplication.run(UukepkbavjtrgidmpjinApplication.class, args);
    }

}
