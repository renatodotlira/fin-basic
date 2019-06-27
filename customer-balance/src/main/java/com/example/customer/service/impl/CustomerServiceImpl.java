package com.example.customer.service.impl;

import com.example.customer.domain.Customer;
import com.example.customer.dto.CustomerCreateDto;
import com.example.customer.dto.CustomerDto;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import com.example.customer.service.AccountMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    AccountMovementService accountMovementService;

    @Override
    public CustomerDto save(CustomerCreateDto customerCreateDto) {
        CustomerDto customerDto = repository.save(customerCreateDto.toModel()).toDto();
        accountMovementService.accountMovementCreate(customerDto);
        return customerDto;
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
        customer.inactiveAccount();
        repository.save(customer);
    }

    @Override
    public CustomerDto findById(String id) {
        Optional<Customer> customerOptional = repository.findById(id);
        if(customerOptional.isPresent())
            return customerOptional.get().toDto();
        else
            return null;
    }

    @Override
    public void debitAccountBalance(String id, double amount) {
        Optional<Customer> customerOptional = repository.findById(id);
        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            customer.debitAccountBalance(amount);
            repository.save(customer);
        }
    }

    @Override
    public void creditAccountBalance(String id, double amount) {
        Optional<Customer> customerOptional = repository.findById(id);
        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            customer.creditAccountBalance(amount);
            repository.save(customer);
        }
    }

    @Override
    public double getAmount(String id) {
        Optional<Customer> customerOptional = repository.findById(id);
        if (customerOptional.isPresent())
            return customerOptional.get().getAtualBalance();
        return 0.0d;
    }
}
