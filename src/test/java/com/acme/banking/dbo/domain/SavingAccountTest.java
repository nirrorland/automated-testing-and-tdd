package com.acme.banking.dbo.domain;

import org.junit.Assert;
import org.junit.Test;


import java.util.UUID;

public class SavingAccountTest {

    private final UUID ID = UUID.randomUUID();
    private final UUID accID = UUID.randomUUID();

    private final String NAME = "testClient";
    private final Client CLIENT = new Client(ID, NAME);
    private final double AMOUNT = 12.01;


    @Test
    public void shouldBeFillingAllArgumentsWhenObjectCreated() {

        SavingAccount sa = new SavingAccount(accID, CLIENT, AMOUNT);

        Assert.assertEquals(accID, sa.getId());
        Assert.assertSame(CLIENT, sa.getClient());
        Assert.assertEquals(AMOUNT, sa.getAmount(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExceptionWhenIdIsNull() {
        new SavingAccount(null, CLIENT, AMOUNT);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExceptionWhenClientIsNull() {

        new SavingAccount(accID, null, AMOUNT);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExceptionWhenAmountBelowZero() {

        new SavingAccount(accID, CLIENT, -0.01);

    }


    @Test
    public void shouldBeNotNullWhenObjectCreated() {

        SavingAccount sa = new SavingAccount(accID, CLIENT, AMOUNT);


        Assert.assertNotNull(sa);
    }

    @Test
    public void shouldGetAccountIDwhenAccessingWithGetter() {
        SavingAccount sa = new SavingAccount(accID, CLIENT, AMOUNT);

        Assert.assertSame(accID, sa.getId());
    }

    @Test
    public void shouldGetClientwhenAccessingWithGetter() {
        SavingAccount sa = new SavingAccount(accID, CLIENT, AMOUNT);

        Assert.assertSame(CLIENT, sa.getClient());
    }

    @Test
    public void shouldGetAmmountwhenAccessingWithGetter() {
        SavingAccount sa = new SavingAccount(accID, CLIENT, AMOUNT);

        Assert.assertSame(AMOUNT, sa.getAmount());
    }

}