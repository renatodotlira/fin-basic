package com.example.customer.service;

import com.example.customer.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerDto customerDto);

    List<CustomerDto> listAll();

    List<CustomerDto> listAllEnabled();

    void disable(CustomerDto customerDto);

}
