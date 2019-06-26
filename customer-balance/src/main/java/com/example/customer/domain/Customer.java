package com.example.customer.domain;

import com.example.customer.dto.CustomerDto;
import com.example.customer.enums.CustomerTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document(collection = "customer")
public class Customer implements Cloneable {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private CustomerTypeEnum customerType;

    private String document;

    private double atualBalance = 0d;

    private boolean enabled = true;

    public Customer() {
    }

    public Customer(CustomerDto customerDto) {
        this.id = customerDto.getId();
        this.name = customerDto.getName();
        this.customerType = customerDto.getCustomerType();
        this.document = customerDto.getDocument();
        this.atualBalance = customerDto.getAtualBalance();
        this.enabled = customerDto.isEnabled();
    }

    public CustomerDto toDto(){
        return new CustomerDto(this);
    }

    public Customer disable(){
        try {
            Customer c = (Customer) this.clone();
            c.enabled = false;
            return c;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
