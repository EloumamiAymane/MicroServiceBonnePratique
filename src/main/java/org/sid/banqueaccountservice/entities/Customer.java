package org.sid.banqueaccountservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String name;
    @OneToMany(mappedBy = "customer")
    private List<BankAccount>bankAccounts;

}
