package org.sid.banqueaccountservice.web;

import lombok.AllArgsConstructor;
import org.sid.banqueaccountservice.DTO.BankAccountRequestDTO;
import org.sid.banqueaccountservice.DTO.BankAccountResponeDTO;
import org.sid.banqueaccountservice.Mapper.AccountMapper;
import org.sid.banqueaccountservice.entities.BankAccount;
import org.sid.banqueaccountservice.repositories.BankAccountRepository;
import org.sid.banqueaccountservice.services.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return  bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById( @Argument String id){
        return  bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account with id %s doesn't exist",id)));
    }
@MutationMapping
    public BankAccountResponeDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponeDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {

        return  accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {

          bankAccountRepository.deleteById(id);
          return  true;
    }
}
//record  BankAccountDTO(double balance,String type,String currency){}
