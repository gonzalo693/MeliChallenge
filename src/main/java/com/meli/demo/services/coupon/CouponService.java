package com.meli.demo.services.coupon;

import com.meli.demo.domain.Response;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CouponService implements ICouponService{

    @Override
    public Response calculateItemListByAmount(Map<String, Float> items, Float amount) {

        List<String> itemsSelected = new ArrayList();
        itemsSelected.add("1");
        itemsSelected.add("3");
        itemsSelected.add("6");


        Response response = new Response(0f,itemsSelected);


        return response;
    }
}
