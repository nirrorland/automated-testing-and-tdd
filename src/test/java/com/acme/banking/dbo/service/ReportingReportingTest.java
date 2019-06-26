package com.acme.banking.dbo.service;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.FinalBranch;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class ReportingReportingTest {

    @Test
    public void shouldWriteAccountReportWhenItFinalBranch() {
        FinalBranch anyFinalBranch = new FinalBranch("AnyFinalBranch");
        SavingAccount anySavingAccount = new SavingAccount(UUID.randomUUID(), new Client(UUID.randomUUID(), "clientName"), 2.0);

        anyFinalBranch.addAccount(anySavingAccount);

        assertTrue(new BranchReporting().getBranchReport(anyFinalBranch).contains("# *" + anySavingAccount.getId() + "* "));
    }

}