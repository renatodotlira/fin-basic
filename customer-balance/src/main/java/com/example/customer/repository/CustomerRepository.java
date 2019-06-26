package com.example.customer.repository;

import com.example.customer.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

//    Customer findByName(String name);

    @Query("{document:'?0'}")
    List<Customer> findByDocument(String document);

    @Query("{enabled:true}")
    List<Customer> findAllEnabled();

}