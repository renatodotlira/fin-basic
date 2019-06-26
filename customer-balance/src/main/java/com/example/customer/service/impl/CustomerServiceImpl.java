package com.example.customer.service.impl;

import com.example.customer.domain.Customer;
import com.example.customer.dto.CustomerDto;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return repository.save(customerDto.toModel()).toDto();
    }

    @Override
    public List<CustomerDto> listAll() {
        List<CustomerDto> customerDtos = new ArrayList<>();
        repository.findAll().forEach(student -> customerDtos.add(student.toDto()));
        return customerDtos;
    }

    @Override
    public List<CustomerDto> listAllEnabled() {
        List<CustomerDto> customerDtos = new ArrayList<>();
        repository.findAllEnabled().forEach(student -> customerDtos.add(student.toDto()));
        return customerDtos;
    }

    @Override
    public void disable(CustomerDto customerDto) {
        Customer customer = customerDto.toModel();
        customer = customer.disable();
        repository.save(customer);
    }
}
