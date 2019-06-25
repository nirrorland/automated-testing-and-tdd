package com.acme.banking.dbo.repo;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Client;

import java.util.UUID;

public interface ClientRepository {
    UUID create(String name);

}
