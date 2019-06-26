package com.acme.banking.dbo.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class BranchTreeTest {

    @Test
    public void shouldHaveNameAndChildrenWhenItTree() {
        BranchTree childrenNode = new BranchTree(null);
        BranchTree testNode = new BranchTree("Name");
        testNode.add(childrenNode);

        assertTrue(testNode.getName().equals("Name"));
        assertTrue((testNode.getChildrens().size() == 1));
        assertTrue(testNode.getChildrens().contains(childrenNode));
        assertTrue(testNode.getChildrens().get(0).equals(childrenNode));
    }

    @Test
    public void shouldHaveNameAndAccountsWhenItFinal() {
        FinalBranch finalBranch = new FinalBranch("name");
        SavingAccount anySavingAccount = new SavingAccount(UUID.randomUUID(), new Client(UUID.randomUUID(), "clientName"), 2.0);
        finalBranch.addAccount(anySavingAccount);

        assertThat(finalBranch.getName().equals("name"));
        assertThat(finalBranch.getAccounts().size() == 1);
        assertThat(finalBranch.getAccounts().contains(anySavingAccount));
    }

    @Test
    public void finalBranchShouldHaveAccount() {
        BranchTree testNode = new BranchTree("testNodeName");
        BranchTree anotherTestNode = new BranchTree("anotherTestNodeName");
        FinalBranch finalBranch = new FinalBranch("finalBranchName");
        SavingAccount anySavingAccount = new SavingAccount(UUID.randomUUID(), new Client(UUID.randomUUID(), "clientName"), 2.0);

        testNode.add(anotherTestNode);
        anotherTestNode.add(finalBranch);
        finalBranch.addAccount(anySavingAccount);


        assertThat(testNode.getChildrens().get(0).getChildrens().get(0).getAccounts().contains(anySavingAccount));
        assertThat(testNode.getChildrens().get(0).getChildrens().get(0).getAccounts().get(0).equals(anySavingAccount));
    }

    @Test
    public void treeBranchShouldHaveNullAccounts() {
        BranchTree testNode = new BranchTree("testNodeName");
        BranchTree anotherTestNode = new BranchTree("anotherTestNodeName");
        FinalBranch finalBranch = new FinalBranch("finalBranchName");
        SavingAccount anySavingAccount = new SavingAccount(UUID.randomUUID(), new Client(UUID.randomUUID(), "clientName"), 2.0);

        testNode.add(anotherTestNode);
        anotherTestNode.add(finalBranch);
        finalBranch.addAccount(anySavingAccount);


        assertThat(testNode.getChildrens().get(0).getAccounts() == null);
    }

    @Test
    public void finalBranchShouldHaveNullChildrens() {
        BranchTree testNode = new BranchTree("testNodeName");
        BranchTree anotherTestNode = new BranchTree("anotherTestNodeName");
        FinalBranch finalBranch = new FinalBranch("finalBranchName");
        SavingAccount anySavingAccount = new SavingAccount(UUID.randomUUID(), new Client(UUID.randomUUID(), "clientName"), 2.0);

        testNode.add(anotherTestNode);
        anotherTestNode.add(finalBranch);
        finalBranch.addAccount(anySavingAccount);


        assertThat(finalBranch.getChildrens() == null);
    }


}
