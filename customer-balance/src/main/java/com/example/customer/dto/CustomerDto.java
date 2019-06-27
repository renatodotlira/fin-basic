package com.example.customer.dto;

import com.example.customer.domain.Customer;
import com.example.customer.enums.CustomerTypeEnum;

import com.example.customer.enums.StatusAccountEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    private String id;

    private String name;

    private CustomerTypeEnum customerType;

    private String document;

    private double atualBalance = 0d;

    private StatusAccountEnum status;

    public CustomerDto() {
    }

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.customerType = customer.getCustomerType();
        this.document = customer.getDocument();
        this.atualBalance = customer.getAtualBalance();
        this.status = customer.getStatus();
    }

    public Customer toModel(){
        return new Customer(this);
    }

}
