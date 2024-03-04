package org.sid.banqueaccountservice.entities;

import org.sid.banqueaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1",types = BankAccount.class)
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
