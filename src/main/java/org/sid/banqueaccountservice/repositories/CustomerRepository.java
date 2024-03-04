package org.sid.banqueaccountservice.repositories;

import jakarta.transaction.Transactional;
import org.sid.banqueaccountservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


public interface CustomerRepository  extends JpaRepository<Customer,Long>{
}
