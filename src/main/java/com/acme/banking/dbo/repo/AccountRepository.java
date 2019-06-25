package com.acme.banking.dbo.repo;

import com.acme.banking.dbo.domain.Account;

import java.util.Collection;
import java.util.UUID;

public interface AccountRepository {
    Account findById(UUID accountId);

    Collection<Account> getByClientId(UUID clientId);

    void transferAmount(UUID fromAccountId, UUID toAccountId, double amount);
}
