package com.mugeeth.bankCrud.controller;

import com.mugeeth.bankCrud.entity.Account;
import com.mugeeth.bankCrud.repository.AccountRepository;
import com.mugeeth.bankCrud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;

    @Autowired
    AccountRepository repository;
    //create the account
    @PostMapping("/create") //Create Bank Account
    @ResponseStatus(code = HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account){
        Account createAccount = service.createAccount(account);
        return createAccount;
    }
    @GetMapping("/{accountNumber}") //Get the Bank Account details by Account number
    public Account getAccountDetailsByAccountNumber(@PathVariable Long accountNumber){
        Account account = service.getAccountDetailsByAccountNumber(accountNumber);
        return account;
    }
    @GetMapping("/getallaccounts") //Get All the Bank Account details
    public List<Account> getAllAccountDetails(){
        List<Account> allAccountDetails = service.getAllAccountDetails();
        return allAccountDetails;
    }
    @PutMapping("/deposit/{accountNumber}/{amount}") //Deposit the money in account
    public Account depositAccount(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account = service.depositAmount(accountNumber, amount);
        return account;
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}") //Withdraw the money from account
    public Account withdrawAccount(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account = service.withdrawAmount(accountNumber, amount);
        return account;
    }

    @DeleteMapping("/delete/{accountNumber}")//Delete or close the account
    public String deleteAccount(@PathVariable Long accountNumber){
        service.closeAccount(accountNumber);
        return "Account Closed";
    }

}
