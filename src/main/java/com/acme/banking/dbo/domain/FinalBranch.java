package com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class FinalBranch implements BranchInterface{

    public String getName() {
        return Name;
    }

    private String Name;

    public ArrayList<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public ArrayList<BranchInterface> getChildrens() {
        return null;
    }

    private Collection<Account> accounts = new ArrayList<>();

    public FinalBranch(String name) {
        Name = name;
    }

    public void addAccount(SavingAccount anySavingAccount) {
        accounts.add(anySavingAccount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalBranch that = (FinalBranch) o;
        return Objects.equals(Name, that.Name) &&
                Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, accounts);
    }
}
