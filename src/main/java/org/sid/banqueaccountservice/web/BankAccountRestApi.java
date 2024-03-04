package org.sid.banqueaccountservice.web;

import lombok.AllArgsConstructor;
import org.sid.banqueaccountservice.DTO.BankAccountRequestDTO;
import org.sid.banqueaccountservice.DTO.BankAccountResponeDTO;
import org.sid.banqueaccountservice.entities.BankAccount;
import org.sid.banqueaccountservice.repositories.BankAccountRepository;
import org.sid.banqueaccountservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class BankAccountRestApi {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    @GetMapping("/BankAccounts")
    public List<BankAccount>listAccount(){
        return  bankAccountRepository.findAll();
    }
    @GetMapping("/BankAccounts/{id}")
    public BankAccount getAccount( @PathVariable String id){
        return  bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/BankAccounts")
    public BankAccountResponeDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @PutMapping("/BankAccounts/{id}")
    public BankAccount updateAccount( @PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount bankAccount1=bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance() !=0) bankAccount1.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency() !=null) bankAccount1.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType() !=null)  bankAccount1.setType(bankAccount.getType());
        if (bankAccount.getDateCreation() !=null)bankAccount1.setDateCreation(bankAccount.getDateCreation());
        return bankAccountRepository.save(bankAccount1);
    }
    @DeleteMapping("/BankAccounts/{id}")
    public void deleteAccount( @PathVariable String id){
          bankAccountRepository.deleteById(id);
    }
}
