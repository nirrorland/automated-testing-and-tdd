package com.acme.banking.dbo.builders;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.repo.ClientRepository;

import java.util.UUID;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientRepiositoryBuilder {

    private ClientRepository clientRepository;

    public ClientRepiositoryBuilder() {
        this.clientRepository = mock(ClientRepository.class);
    }


    public ClientRepiositoryBuilder withClientAndUUID(String name, UUID uuid){
        when(clientRepository.create(name)).thenReturn(uuid);
        return  this;
    }

    public ClientRepiositoryBuilder withThrown(String name){
        when(clientRepository.create(name)).thenThrow(IllegalArgumentException.class);
        return  this;
    }

    public ClientRepository build() {
        return clientRepository;
    }
}

