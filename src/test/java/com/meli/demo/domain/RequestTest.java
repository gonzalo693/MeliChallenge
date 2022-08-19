package com.meli.demo.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {


    private final Set<String> itemsIds = new HashSet();
    private final Float amount = 100.0F;


    @Test
    public void whitNoArgConstructor() {

        itemsIds.add("1");
        itemsIds.add("2");
        itemsIds.add("3");

        Request request = new Request();
        request.setAmount(amount);
        request.setItemIds(itemsIds);


        assertNotNull(request);
        assertEquals(request.getItemIds(), itemsIds);
        assertEquals(request.getAmount(), amount);

    }

}