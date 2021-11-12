package fr.shcherbakov.countservice.services;

import fr.shcherbakov.countservice.repositories.AccountRepository;

public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

}
