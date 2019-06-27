package com.example.customer.repository;

import com.example.customer.domain.AccountMovement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AccountMovementRepository extends MongoRepository<AccountMovement, String> {

    @Query("{customerId:'?0'}")
    List<AccountMovement> findByid(String id);

}