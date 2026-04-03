package com.example.bank;

import com.example.bank.dto.AccountRequest;
import com.example.bank.service.BankService;
import com.example.bank.model.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {

    BankService service = new BankService();

    @PostMapping("/create")
    public String create(@RequestBody AccountRequest request) {
        return service.createAccount(request.id, request.name);
    }

    @GetMapping("/account/{id}")
    public Account get(@PathVariable int id) {
        return service.getAccount(id);
    }

    @PostMapping("/deposit/{id}")
    public String deposit(@PathVariable int id, @RequestParam double amount) {
        return service.deposit(id, amount);
    }

    @PostMapping("/withdraw/{id}")
    public String withdraw(@PathVariable int id, @RequestParam double amount) {
        return service.withdraw(id, amount);
    }
}