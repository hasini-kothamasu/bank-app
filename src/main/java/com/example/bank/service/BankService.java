package com.example.bank.service;

import com.example.bank.model.Account;
import java.util.*;

public class BankService {

    private Map<Integer, Account> accounts = new HashMap<>();

    public String createAccount(int id, String name) {
        accounts.put(id, new Account(id, name, 0));
        return "Account Created";
    }

    public Account getAccount(int id) {
        return accounts.get(id);
    }

    public String deposit(int id, double amount) {
        Account acc = accounts.get(id);
        if (acc == null) return "Account not found";

        acc.setBalance(acc.getBalance() + amount);
        return "Deposited Successfully";
    }

    public String withdraw(int id, double amount) {
        Account acc = accounts.get(id);
        if (acc == null) return "Account not found";

        if (acc.getBalance() < amount)
            return "Insufficient Balance";

        acc.setBalance(acc.getBalance() - amount);
        return "Withdraw Successful";
    }
}