package com.example.customer.dto;

import com.example.customer.domain.Customer;
import com.example.customer.enums.CustomerTypeEnum;
import com.example.customer.enums.StatusAccountEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreateDto {

    private String name;

    private CustomerTypeEnum customerType;

    private String document;

    private double initialBalance = 0d;

    public CustomerCreateDto() {
    }

    public CustomerCreateDto(Customer customer) {
        this.name = customer.getName();
        this.customerType = customer.getCustomerType();
        this.document = customer.getDocument();
        this.initialBalance = customer.getAtualBalance();
    }

    public Customer toModel(){
        Customer customer = new Customer();
        customer.setName(this.name);
        customer.setCustomerType(this.customerType);
        customer.setDocument(this.document);
        customer.setAtualBalance(this.initialBalance);
        customer.setStatus(StatusAccountEnum.CREATED);
        return customer;
    }

}
