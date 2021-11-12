package fr.shcherbakov.countservice.repositories;

import fr.shcherbakov.countservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
