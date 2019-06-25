package com.acme.banking.dbo.service;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.repo.AccountRepository;
import org.junit.Test;

import java.util.UUID;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ReportingTest {

    @Test
    public void shouldGetMarkdownReportWhenClientExists() {
        AccountRepository stubRepo = mock(AccountRepository.class);
        Account stubAccount = mock(Account.class);
        UUID accountId = UUID.randomUUID();

        when(stubAccount.getId()).thenReturn(accountId);
        when(stubAccount.getClientId()).thenReturn(accountId);
        when(stubRepo.findById(any(UUID.class))).thenReturn(stubAccount);

        when(stubRepo.findById(accountId)).thenReturn(null)
                                        .thenReturn(stubAccount)
                                        .thenThrow(new IllegalStateException());
        ;

        Reporting sut = new Reporting(stubRepo);
        assertThat(sut.getReport(accountId)).contains("# *" + accountId + "* ");
    }

}