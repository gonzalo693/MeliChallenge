package com.meli.demo.controller;

import com.meli.demo.domain.Request;
import com.meli.demo.domain.Response;
import com.meli.demo.services.coupon.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cupon")
public class CouponController  {

   @Autowired
    CouponService couponService;


   public CouponController(CouponService couponService){this.couponService=couponService;}



    @RequestMapping(value = "/validarCupon",method = RequestMethod.POST)
    public ResponseEntity <Response> CuponProcess(@RequestBody Request request){
      Map<String, Float> items = new HashMap<>();
      Float number = Float.valueOf(1);
      couponService.calculateItemListByAmount(items,number);

      return new ResponseEntity<Response>(couponService.calculateItemListByAmount(items,number), HttpStatus.OK);
    }

}
