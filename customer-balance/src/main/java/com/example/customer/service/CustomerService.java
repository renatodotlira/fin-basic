package com.example.customer.service;

import com.example.customer.dto.CustomerCreateDto;
import com.example.customer.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerCreateDto customerDto);

    List<CustomerDto> listAll();

    List<CustomerDto> listAllEnabled();

    void disable(CustomerDto customerDto);

    CustomerDto findById(String id);

    void debitAccountBalance(String id, double amount);

    void creditAccountBalance(String id, double amount);

    double getAmount(String id);

}
