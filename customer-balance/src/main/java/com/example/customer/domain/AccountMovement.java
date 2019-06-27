package com.example.customer.domain;

import com.example.customer.dto.AccountMovementDto;
import com.example.customer.enums.StatusAccountEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "account-movement")
public class AccountMovement implements Cloneable {

    @Id
    private String id = UUID.randomUUID().toString();

    private String customerId;

    private double debitAmount;

    private double creditAmount;

    private StatusAccountEnum status;

    private String dateMovement;

    public AccountMovement() {
    }

    public AccountMovementDto toDto(){
        return new AccountMovementDto(this);
    }

    public void setDateMovement(){
        Format formatter;
        formatter = new SimpleDateFormat("MM/dd/yy hh:mm");
        this.dateMovement = formatter.format(new Date());
    }

}
