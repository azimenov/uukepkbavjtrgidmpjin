package com.example.uukepkbavjtrgidmpjin.salesman.repository;

import com.example.uukepkbavjtrgidmpjin.salesman.model.Salesman;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesmanRepository extends MongoRepository<Salesman, Integer> {

    Salesman save(Salesman salesman);
}
