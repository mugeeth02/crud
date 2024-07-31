package com.mugeeth.bankCrud.service;

import com.mugeeth.bankCrud.entity.Account;
import com.mugeeth.bankCrud.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository repository;
    @Override
    public Account createAccount(Account account) {
        Account accountSaved = repository.save(account);
        return accountSaved;
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber) {
        Optional<Account> account = repository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not Present");
        }
        Account accountFound = account.get();
        return accountFound;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> listOfAllAccounts = repository.findAll();
        return listOfAllAccounts;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Optional<Account> account = repository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent = account.get();
        Double totalBalance = accountPresent.getAccountBalance() + amount;
        accountPresent.setAccountBalance(totalBalance);
        repository.save(accountPresent);
        return accountPresent;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Optional<Account> account = repository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent = account.get();
        Double accountBalance = accountPresent.getAccountBalance() - amount;
        accountPresent.setAccountBalance(accountBalance);
        repository.save(accountPresent);
        return accountPresent;
    }

    @Override
    public void closeAccount(Long accountNumber) {
        getAccountDetailsByAccountNumber(accountNumber);
        repository.deleteById(accountNumber);
    }
}
