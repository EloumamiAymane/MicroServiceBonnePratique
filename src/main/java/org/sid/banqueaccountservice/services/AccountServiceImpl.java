package org.sid.banqueaccountservice.services;

import lombok.AllArgsConstructor;
import org.sid.banqueaccountservice.DTO.BankAccountRequestDTO;
import org.sid.banqueaccountservice.DTO.BankAccountResponeDTO;
import org.sid.banqueaccountservice.Mapper.AccountMapper;
import org.sid.banqueaccountservice.entities.BankAccount;
import org.sid.banqueaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;
@AllArgsConstructor
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponeDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDTO.getType())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .dateCreation(new Date()).build();
        BankAccount savedAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponeDTO bankAccountResponeDTO=accountMapper.fromBankAccount(savedAccount);


        return bankAccountResponeDTO;
    }

    @Override
    public BankAccountResponeDTO updateAccount(String id,BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccountt=BankAccount.builder()
                .id(id)
                .type(bankAccountRequestDTO.getType())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency()).build();
        BankAccount savedAccount = bankAccountRepository.save(bankAccountt);
        BankAccountResponeDTO bankAccountResponeDTO=accountMapper.fromBankAccount(savedAccount);
        return bankAccountResponeDTO;
    }
}
