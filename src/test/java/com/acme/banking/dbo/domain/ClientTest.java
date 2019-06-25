package com.acme.banking.dbo.domain;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.UUID;


public class ClientTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private final UUID ID = UUID.randomUUID();
    private final String NAME = "testClient";

    @Test
    public void shouldBeFillingAllArgumentsWhenObjectCreated() {
        Client cl = new Client(ID, NAME);

        Assert.assertEquals(ID, cl.getId());
        Assert.assertEquals(NAME, cl.getName());
    }

    @Test
    public void shouldThrowIllegalArgExceptionWhenIdIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Id should not be null");

        new Client(null, NAME);

    }

    @Test
    public void shouldThrowIllegalArgExceptionWhenNameIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Name should not be null");

        new Client(ID, null);
    }

    @Test
    public void shouldThrowIllegalArgExceptionWhenNameIsEmpty() {
        new Client(ID, "");
    }

    @Test
    public void shouldThrowIllegalArgExceptionWhenAllArgsIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Id should not be null");

        new Client(null, null);
    }

    @Test
    public void shouldBeNotNullWhenObjectCreated() {
        Client cl = new Client(ID, NAME);
        Assert.assertNotNull(cl);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenAccountIsNull(){
        Client cl = new Client(ID, NAME);

        thrown.expect(NullPointerException.class);
        cl.addAccount(null);
    }

    @Test
    public void shouldThrowIllegalStateExceptionWhenAccountLinkToDifferentClient(){
        Client anyClient = new Client(ID, NAME);
        Client existingCount = new Client(UUID.randomUUID(), NAME);

        UUID anyAccountId = UUID.randomUUID();
        SavingAccount sa = new SavingAccount(anyAccountId, existingCount, 0);

        thrown.expect(IllegalStateException.class);
        anyClient.addAccount(sa);
    }
}