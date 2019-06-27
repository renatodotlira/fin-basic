package com.example.customer.dto;

import com.example.customer.domain.AccountMovement;
import com.example.customer.enums.StatusAccountEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountMovementDto implements Cloneable {

    private String id;

    private String customerId;

    private double debitAmount;

    private double creditAmount;

    private StatusAccountEnum status;

    private String dateMovement;

    public AccountMovementDto(AccountMovement accountMovement) {
        this.id = accountMovement.getId();
        this.customerId = accountMovement.getCustomerId();
        this.creditAmount = accountMovement.getCreditAmount();
        this.debitAmount = accountMovement.getDebitAmount();
        this.status = accountMovement.getStatus();
        this.dateMovement = accountMovement.getDateMovement();
    }

}