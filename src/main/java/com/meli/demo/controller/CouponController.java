package com.meli.demo.controller;

import com.meli.demo.domain.Request;
import com.meli.demo.domain.Response;
import com.meli.demo.services.bean.Product;
import com.meli.demo.services.coupon.CouponService;
import com.meli.demo.services.product.ProductConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cupon")
public class CouponController  {

   @Autowired
    CouponService couponService;

   public CouponController(CouponService couponService){this.couponService=couponService;}



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

    @GetMapping("/coupon/stats")
    public List<Product> GetCouponStats(){
        List<Product> topItems = new ArrayList<Product>();
        couponService.getTopItems().entrySet().stream().forEach(i -> {
            topItems.add(new Product(i.getKey(), i.getValue()));
        });
        return topItems;
    }

}
