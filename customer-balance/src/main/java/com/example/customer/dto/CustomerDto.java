package com.example.customer.dto;

import com.example.customer.domain.Customer;
import com.example.customer.enums.CustomerTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
public class CustomerDto {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private CustomerTypeEnum customerType;

    private String document;

    private double atualBalance = 0d;

    private boolean enabled = true;

    public CustomerDto() {
    }

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.customerType = customer.getCustomerType();
        this.document = customer.getDocument();
        this.atualBalance = customer.getAtualBalance();
        this.enabled = customer.isEnabled();
    }

    public Customer toModel(){
        return new Customer(this);
    }

}
