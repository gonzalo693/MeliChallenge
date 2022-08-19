package com.meli.demo.controller;

import com.meli.demo.domain.Request;
import com.meli.demo.domain.Response;
import com.meli.demo.services.bean.Product;
import com.meli.demo.services.coupon.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cupon")
public class CouponController  {

/**
 * This class is a controller for handling <b>Coupon API requests</b>.
 * The purpose of this API is to calculate a coupon selecting one or more items from the user's favorite list and maximize the coupon value.
 * <p>
 * In order to get the items prices the Coupon API will invoke MELI's Items API and store the values retrieved in memory
 */

   @Autowired
    CouponService couponService;

   public CouponController(CouponService couponService){this.couponService=couponService;}


    /** Returns a coupon containing a subset of items whose sum of their price is equals or nearest to a limit.*/
    @RequestMapping(value = "/validarCupon",method = RequestMethod.POST)
    public ResponseEntity <Response> CuponProcess(@RequestBody Request request){

        Response response;
        try {
            response = couponService.calculateItemListByAmount(request);
        } catch (Exception e) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

      return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

   /** Returns a top n list of statistics for the most used items among all coupons generated.*/
    @GetMapping("/coupon/stats")
    public List<Product> GetCouponStats(){
        List<Product> topItems = new ArrayList<Product>();
        couponService.getTopItems().entrySet().stream().forEach(i -> {
            topItems.add(new Product(i.getKey(), i.getValue()));
        });
        return topItems;
    }

}
