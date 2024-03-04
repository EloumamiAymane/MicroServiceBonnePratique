package org.sid.banqueaccountservice.Mapper;

import org.sid.banqueaccountservice.DTO.BankAccountRequestDTO;
import org.sid.banqueaccountservice.DTO.BankAccountResponeDTO;
import org.sid.banqueaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponeDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponeDTO bankAccountResponeDTO= new BankAccountResponeDTO();
         BeanUtils.copyProperties(bankAccount, bankAccountResponeDTO);
         return  bankAccountResponeDTO;
    }
}
