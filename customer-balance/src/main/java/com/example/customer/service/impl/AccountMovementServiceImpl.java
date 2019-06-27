package com.example.customer.service.impl;

import com.example.customer.domain.AccountMovement;
import com.example.customer.dto.CustomerDto;
import com.example.customer.dto.AccountMovementDto;
import com.example.customer.repository.AccountMovementRepository;
import com.example.customer.service.AccountMovementService;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountMovementServiceImpl implements AccountMovementService {

    @Autowired
    AccountMovementRepository repository;

    @Autowired
    CustomerService customerService;

    @Override
    public void accountMovementCreate(CustomerDto customerDto) {

        AccountMovement accountMovement = new AccountMovement();
        accountMovement.setCustomerId(customerDto.getId());
        accountMovement.setCreditAmount(customerDto.getAtualBalance());
        accountMovement.setStatus(customerDto.getStatus());
        accountMovement.setDateMovement();
        repository.save(accountMovement);
    }

    @Override
    public List<AccountMovementDto> listAllById(String id) {
        List<AccountMovementDto> accountMovementDtos = new ArrayList<>();
        repository.findByid(id).forEach(accountMovement -> accountMovementDtos.add(accountMovement.toDto()));
        return accountMovementDtos;
    }

    @Override
    public void debitAccount(String id, double amount) {
        AccountMovement accountMovement = new AccountMovement();
        accountMovement.setCustomerId(id);
        accountMovement.setDebitAmount(amount);
        accountMovement.setDateMovement();
        customerService.debitAccountBalance(id, amount);
        repository.save(accountMovement);
    }

    @Override
    public void creditAccount(String id, double amount) {
        AccountMovement accountMovement = new AccountMovement();
        accountMovement.setCustomerId(id);
        accountMovement.setCreditAmount(amount);
        accountMovement.setDateMovement();
        customerService.creditAccountBalance(id, amount);
        repository.save(accountMovement);
    }

}
