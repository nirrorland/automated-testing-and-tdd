package com.acme.banking.dbo.service;


import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.repo.AccountRepository;
import com.acme.banking.dbo.repo.ClientRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class ProcessingTest {
    private static final double ANY_AMOUNT = 1.0;
    private static final UUID ANY_UUID = UUID.randomUUID();
    private static final String ANY_NAME = "AnyClient";

    @Test
    public void shouldLogTxWithTxLogWhenCacheOperation() {
        TxLog mockTxLog = mock(TxLog.class);
        ClientRepository mockClients = mock(ClientRepository.class);
        AccountRepository mockAccounts = mock(AccountRepository.class);

        Processing sut = new Processing(mockTxLog, mockClients, mockAccounts);

        sut.cash(ANY_AMOUNT, ANY_UUID);

        verify(mockTxLog, times(1))
                .log(anyDouble(), any(UUID.class));
    }

    @Test
    public void shouldInvokeCreateOnClientRepoWhenClientCreated() {
        TxLog mockTxLog = mock(TxLog.class);
        ClientRepository mockClients = mock(ClientRepository.class);
        AccountRepository mockAccounts = mock(AccountRepository.class);

        Processing sut = new Processing(mockTxLog, mockClients, mockAccounts);

        sut.createClient(ANY_NAME);

        verify(mockClients, times(1))
                .create(ANY_NAME);
    }

    @Test
    public void shouldReturnUUIDWhenClientCreated() {
        TxLog mockTxLog = mock(TxLog.class);
        ClientRepository mockClients = mock(ClientRepository.class);
        AccountRepository mockAccounts = mock(AccountRepository.class);
        UUID returnedUUID = UUID.randomUUID();

        when(mockClients.create(anyString())).thenReturn(returnedUUID);

        Processing sut = new Processing(mockTxLog, mockClients, mockAccounts);

        Assert.assertEquals(returnedUUID,  sut.createClient(ANY_NAME));

    }

    @Test
    public void shouldInvokeGetClientOnAccountRepoWhenClientCreated() {
        TxLog mockTxLog = mock(TxLog.class);
        ClientRepository mockClients = mock(ClientRepository.class);
        AccountRepository mockAccounts = mock(AccountRepository.class);

        Processing sut = new Processing(mockTxLog, mockClients, mockAccounts);

        sut.getAccountsByClientId(ANY_UUID);

        verify(mockAccounts, times(1))
                .getByClientId(any(UUID.class));

    }

    @Test
    public void shouldReturnAccountsWhenRequestedSearchByClientId() {
        TxLog mockTxLog = mock(TxLog.class);
        ClientRepository mockClients = mock(ClientRepository.class);
        AccountRepository mockAccounts = mock(AccountRepository.class);

        Collection<Account> returnedAccount = new ArrayList<>();
        when(mockAccounts.getByClientId(any(UUID.class))).thenReturn(returnedAccount);

        Processing sut = new Processing(mockTxLog, mockClients, mockAccounts);

        Assert.assertSame(returnedAccount,sut.getAccountsByClientId(ANY_UUID));
    }

    @Test
    public void shouldInvokeTransferOnAccountRepoWhenTransferCalled() {
        TxLog mockTxLog = mock(TxLog.class);
        ClientRepository mockClients = mock(ClientRepository.class);
        AccountRepository mockAccounts = mock(AccountRepository.class);

        Processing sut = new Processing(mockTxLog, mockClients, mockAccounts);

        sut.transfer(ANY_AMOUNT, ANY_UUID, ANY_UUID);

        verify(mockAccounts, times(1))
                .transferAmount(any(UUID.class), any(UUID.class), anyDouble());

    }
}