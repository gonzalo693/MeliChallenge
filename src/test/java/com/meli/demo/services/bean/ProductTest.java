package com.meli.demo.services.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class ProductTest {

    Product testProduct = new Product("MLA1",1);

    @Test
    public void testSetProduct() {
        testProduct.setItemId("MLA2");
        assertTrue(testProduct.getItemId() == "MLA2");
    }

    @Test
    public void testGetProduct() {

        assertTrue(testProduct.getItemId() == "MLA1");
    }
    @Test
    public void testSetCounter() {
       testProduct.setCounter(3);
        assertTrue(testProduct.getCounter() == 3);
    }

    @Test
    public void testGetCounter() {

        assertTrue(testProduct.getCounter() == 1);
    }

}