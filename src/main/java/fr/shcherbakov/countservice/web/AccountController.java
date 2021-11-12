package fr.shcherbakov.countservice.web;

import fr.shcherbakov.countservice.aspect.Loggable;
import fr.shcherbakov.countservice.entities.Account;
import fr.shcherbakov.countservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/api/accounts")
    @Loggable
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/api/accounts/{id}")
    @Loggable
    public Account getAccountById(@PathVariable Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("No account with such ID"));
    }

    @PostMapping("/api/accounts")
    @Loggable
    public Account saveAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PutMapping("/api/accounts/{id}")
    @Loggable
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account) {
        account.setId(id);
        return accountRepository.save(account);
    }

    @DeleteMapping("/api/accounts/{id}")
    @Loggable
    public void deleteAccount(@PathVariable Long id) {
        if (accountRepository.findById(id).isPresent()) accountRepository.deleteById(id);
    }
}
