package com.meli.demo.services.coupon;

import com.meli.demo.domain.Request;
import com.meli.demo.domain.Response;
import com.meli.demo.services.bean.Product;
import com.meli.demo.services.product.ProductConsumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CouponServiceTest {

    CouponService couponService = new CouponService();
    private static  Float amount = Float.valueOf(50000);
    private Set<String> itemIds = new HashSet<>(Arrays.asList("MLA811601010","MLA810645375"));
    private List<String> itemIdsResponse = Arrays.asList("MLA811601010","MLA810645375");
    private static  Float amountResponse = Float.valueOf(36698);

    private String idsToApi = "MLA811601010,MLA810645375";

    @BeforeEach
    void setUp(){

    }
    private Request givenRequest(){
        Request request = new Request(amount,itemIds);
        return request;
    }

    private Request givenRequestExpectedOk(){
        Request request = new Request(amount,itemIds);
        return request;
    }


    private Response givenResponse(){
        Response response = new Response(amountResponse,itemIdsResponse);
        return response;
    }

    private Map<String, Float> givenMapResponseApi(){
        Map<String, Float> map = new HashMap<>();
        map.put("MLA811601010",Float.valueOf(19699));
        map.put("MLA810645375",Float.valueOf(16999));

        return map;
    }

    @Test
    void givenRequestOK_thenSaveItems(){
        var request = givenRequest();
        var responseExpected = givenResponse();
        Response responseActual = new Response();
        var mapResponseApi  = givenMapResponseApi();
        ProductConsumer productConsumer = mock(ProductConsumer.class);;
        when(productConsumer.getProductPrices(idsToApi)).thenReturn(mapResponseApi);

        try{
            responseActual  =  couponService.calculateItemListByAmount(request);
        }catch(Exception ex){

        }
        assertEquals(refEq(responseExpected),refEq(responseActual));
    }
    private Request emptyRequest(){
        Request request = new Request();
        return request;
    }

    @Test
    void givenBadRequest_thenThrowException(){
        var request = emptyRequest();
        assertThrows(Exception.class,()->couponService.calculateItemListByAmount(request));
    }

}