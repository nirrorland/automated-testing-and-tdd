package com.acme.banking.dbo.service;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Branch;
import com.acme.banking.dbo.domain.BranchInterface;
import com.acme.banking.dbo.repo.AccountRepository;

import java.util.UUID;

public class Reporting {
    /**
     * @return Markdown report for all branches, clients, accounts
     */

    private AccountRepository accounts;




//Creational responsibility

    //"Creator" [GRASP] patterm
    //private AccountRepository accounts = new JpaAccRepo();

    //"Factory method" -> Abstract Factory [GoF] -> Registry [PoEAA]
    //Factory
    //private AccountRepository accounts = new AccJSONRepoFactory.create();

    //AbstractFactory
    //private AccountRepository accounts = new AccAbstractRepoFactory.create();

    //Repository
    //....


    //Field Dependency Injection
    //....

    //Constructor dependency injection
    public Reporting(AccountRepository accounts) {
        this.accounts = accounts;
    }

    //Setter Dependency Injection
    //.... (don't use cause of mutable data)
    public void setAccounts(AccountRepository accounts) {
        this.accounts = accounts;
    }


    public String getReport(UUID accountId) {
        //TODO impl

        Account account = accounts.findById(accountId);

        return "# *" + account.getId() + "* " + account.getClientId();
    }

    public String getBranchReport(BranchInterface branch) {
        //TODO impl

      return null;
    }
}
