package fr.shcherbakov.countservice.entities;

import fr.shcherbakov.countservice.entities.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private Double debit;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

}
