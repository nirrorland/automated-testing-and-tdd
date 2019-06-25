package com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;

    public Collection<UUID> getAccountIds() {
        return accountIds;
    }

    private Collection<UUID> accountIds = new ArrayList<>(); //TODO

    public Client(UUID id, String name) {
        if (id == null ) throw new IllegalArgumentException("Id should not be null");
        if (name == null) throw new IllegalArgumentException("Name should not be null");
        if (name.isEmpty()) throw new IllegalArgumentException("Name should not be empty");


        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(SavingAccount savingAccount) {
        Objects.requireNonNull(savingAccount);
        if (savingAccount.getClientId() != id) throw new IllegalStateException();

        accountIds.add(savingAccount.getId());

    }
}
