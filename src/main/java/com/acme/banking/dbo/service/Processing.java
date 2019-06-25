package com.acme.banking.dbo.service;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.repo.AccountRepository;
import com.acme.banking.dbo.repo.ClientRepository;

import java.util.Collection;
import java.util.UUID;

//TODO impl
public class Processing {
    private TxLog txLog;
    private ClientRepository clients;
    private AccountRepository accounts;

    public Processing(TxLog txLog, ClientRepository clients, AccountRepository accounts) {
        this.txLog = txLog;
        this.clients = clients;
        this.accounts = accounts;
    }

    public UUID createClient(String name) {
        return clients.create(name);
    }

    public Collection<Account> getAccountsByClientId(UUID clientId) {
        return accounts.getByClientId(clientId);
    }

    public void transfer(double amount, UUID fromAccountId, UUID toAccountId) {
        accounts.transferAmount(fromAccountId, toAccountId, amount);
    }

    public void cash(double amount, UUID fromAccountId) {
        txLog.log(amount, fromAccountId);
    }
}