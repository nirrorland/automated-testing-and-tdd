package com.acme.banking.dbo.domain;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.util.UUID;

public class SavingAccountTest {

    private final UUID ID = UUID.randomUUID();
    private final UUID accID = UUID.randomUUID();

    private final String NAME = "testClient";
    private final Client CLIENT = new Client(ID, NAME);
    private final double AMOUNT = 12.01;


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldBeFillingAllArgumentsWhenObjectCreated() {

        SavingAccount sa = new SavingAccount(accID, CLIENT, AMOUNT);

        Assert.assertEquals(accID, sa.getId());
        Assert.assertSame(CLIENT, sa.getClient());
        Assert.assertEquals(AMOUNT, sa.getAmount(), 0.00001);
        Assert.assertTrue(CLIENT.getAccountIds().contains(sa.getId()));
    }

    @Test
    public void shouldThrowIllegalArgExceptionWhenIdIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Id should not be null");
        new SavingAccount(null, CLIENT, AMOUNT);

    }

    @Test
    public void shouldThrowIllegalArgExceptionWhenClientIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Client should not be null");

        new SavingAccount(accID, null, AMOUNT);

    }

    @Test
    public void shouldThrowIllegalArgExceptionWhenAmountBelowZero() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Amount  should  be above zero");
        new SavingAccount(accID, CLIENT, -0.01);
    }

    @Test
    public void shouldBeFillingAllArgumentsWhenObjectCreatedWithAmmountIsZero() {

        SavingAccount sa = new SavingAccount(accID, CLIENT, 0);

        Assert.assertEquals(accID, sa.getId());
        Assert.assertSame(CLIENT, sa.getClient());
        Assert.assertEquals(0.0, sa.getAmount(), 0.00001);
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

        Assert.assertEquals(AMOUNT, sa.getAmount(), 0.0001);
    }

}