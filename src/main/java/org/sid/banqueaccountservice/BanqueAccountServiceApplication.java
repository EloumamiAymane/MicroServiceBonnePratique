package org.sid.banqueaccountservice;

import org.sid.banqueaccountservice.entities.BankAccount;
import org.sid.banqueaccountservice.entities.Customer;
import org.sid.banqueaccountservice.enums.AccountType;
import org.sid.banqueaccountservice.repositories.BankAccountRepository;
import org.sid.banqueaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BanqueAccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BanqueAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return args -> {
			Stream.of("Aymane","Mohammed","Othmane","Kaoutar").forEach(c->{
				Customer customer =Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);
			});


customerRepository.findAll().forEach(c->{
	for (int i = 0; i <10 ; i++) {
		BankAccount bankAccount=BankAccount.builder()
				.id(UUID.randomUUID().toString())
				.type(Math.random()>0.5 ? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
				.balance(1000+Math.random()*9000)
				.dateCreation(new Date())
				.currency("MAD")
				.customer(c)
				.build();
		bankAccountRepository.save(bankAccount);

	}
});

			//bankAccountRepository.findAll().forEach(System.out::println);
		};

	}

}
