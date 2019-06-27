package com.example.customer.service;

import com.example.customer.dto.CustomerDto;
import com.example.customer.dto.AccountMovementDto;

import java.util.List;

public interface AccountMovementService {

    void accountMovementCreate(CustomerDto customerDto);

    List<AccountMovementDto> listAllById(String id);

    void debitAccount(String id, double amount);

    void creditAccount(String id, double amount);

}

