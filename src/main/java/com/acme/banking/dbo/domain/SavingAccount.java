package com.acme.banking.dbo.domain;

import java.util.UUID;

public class SavingAccount implements Account {
    private UUID id;
    private Client client;
    private double amount;

    public SavingAccount(UUID id, Client client, double amount) {
        if (id == null ) throw new IllegalArgumentException("Id should not be null");
        if (client == null ) throw new IllegalArgumentException("Client should not be null");
        if (amount < 0  ) throw new IllegalArgumentException("Amount  should  be above zero");

        this.id = id;
        this.client = client;
        this.amount = amount;

        client.addAccount(this);
    }

    public Client getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public UUID getClientId() {
        return client.getId();
    }
}
