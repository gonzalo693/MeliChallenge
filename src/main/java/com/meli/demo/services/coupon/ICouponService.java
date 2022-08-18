package com.meli.demo.services.coupon;

import com.meli.demo.domain.Response;

import java.util.List;
import java.util.Map;

public interface ICouponService {

    Response calculateItemListByAmount(Map<String, Float> items, Float amount);
}
