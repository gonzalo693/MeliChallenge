package com.meli.demo.services.coupon;

import com.meli.demo.domain.Request;
import com.meli.demo.domain.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ICouponService {

    Response calculateItemListByAmount(Request request) throws Exception;
    HashMap<String, Integer> getTopItems();
}
