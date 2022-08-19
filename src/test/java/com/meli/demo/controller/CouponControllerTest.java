package com.meli.demo.controller;

import com.meli.demo.domain.Request;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CouponControllerTest {

    @Autowired
    CouponController couponController;

    @Test
    void givenEmptyItemId_whenItemIsRetrieved_then404IsReceived() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(String.format("https://api.mercadolibre.com/items?ids=%s", "")))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertTrue(response.statusCode() == HttpStatus.NOT_FOUND.value());
    }

    @Test
    void givenItemId_whenItemIsRetrieved_then200IsReceived() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(String.format("https://api.mercadolibre.com/items?ids=%sMLA759942879,MLA768430699", "10000")))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertTrue(response.statusCode() == HttpStatus.OK.value());
    }
    @Test
    public void givenMoreThan20ItemsId_whenItemIsRetrieved_then400IsReceived() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.mercadolibre.com/items?ids=MLA792238696,MLA768430699,MLA750188014,MLA774448514,MLA791881020,MLA779964373,MLA759942879,MLA766832798,MLA791074957,MLA792643250,MLA753491597,MLA756385586,MLA767418898,MLA764746727,MLA760268876,MLA780917124,MLA784241563,MLA749083853,MLA773561899,MLA767858883,MLA770556569,MLA772802098,MLA750064467"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertTrue(response.statusCode() == HttpStatus.BAD_REQUEST.value());
    }

}