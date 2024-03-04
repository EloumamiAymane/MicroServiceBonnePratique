package org.sid.banqueaccountservice.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.banqueaccountservice.enums.AccountType;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponeDTO {
    private String id;
    private Date dateCreation;
    private double balance;
    private String currency;
    private AccountType type;
}
