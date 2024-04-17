package org.sid.banqueaccountservice.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.sid.banqueaccountservice.entities.Customer;
import org.sid.banqueaccountservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest

public class CustomerRepositoryTest {
    @Autowired
    private   CustomerRepository customerRepository;
    @Test
    public void testSaveCustomer() {
        Customer customer = Customer.builder()
                .name("Aymane")
                .build();
        Customer savedCustomer=  customerRepository.save(customer);
        Assertions.assertNotNull(savedCustomer);
    }


}
