package org.sid.banqueaccountservice.services;

import org.sid.banqueaccountservice.DTO.BankAccountRequestDTO;
import org.sid.banqueaccountservice.DTO.BankAccountResponeDTO;

public interface AccountService {
    public BankAccountResponeDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
    public BankAccountResponeDTO updateAccount(String id,BankAccountRequestDTO bankAccountRequestDTO);
}
