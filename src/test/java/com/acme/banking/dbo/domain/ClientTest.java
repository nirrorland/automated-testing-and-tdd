package com.acme.banking.dbo.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class ClientTest {

    private final UUID ID = UUID.randomUUID();
    private final String NAME = "testClient";

    @Test
    public void shouldBeFillingAllArgumentsWhenObjectCreated() {

        Client cl = new Client(ID, NAME);

//        Assert.assertNotNull();
        Assert.assertEquals(ID, cl.getId());
        Assert.assertEquals(NAME, cl.getName());
    }

    @Test(expected =  IllegalArgumentException.class)
    public void shouldThrowIllegalArgExceptionWhenIdIsNull() {
        new Client(null, NAME);

    }

    @Test(expected =  IllegalArgumentException.class)
    public void shouldThrowIllegalArgExceptionWhenNameIsNull() {

        new Client(ID, null);

    }

    @Test(expected =  IllegalArgumentException.class)
    public void shouldThrowIllegalArgExceptionWhenAllArgsIsNull() {

        new Client(null, null);

    }

    @Test
    public void shouldBeNotNullWhenObjectCreated() {

        Client cl = new Client(ID, NAME);


        Assert.assertNotNull(cl);
    }
}