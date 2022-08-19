package com.meli.demo.services.coupon;

import com.meli.demo.domain.Request;
import com.meli.demo.domain.Response;
import com.meli.demo.services.product.ProductConsumer;
import com.meli.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CouponService implements ICouponService{

    @Autowired
    ProductConsumer productConsumer;

    @Autowired
    ProductRepository productRepository;
    @Override
    public Response calculateItemListByAmount(@RequestBody Request request) throws Exception {
        String idSplited = "";

        if (request == null || request.getItemIds() == null || request.getItemIds().isEmpty()) {
            throw new Exception();
        }

        idSplited = this.getIds(request.getItemIds());
        Map<String, Float> returnValues  = productConsumer.getProductPrices(idSplited);
        List<String> productList = calculate(returnValues,request.getAmount());

        if(productList == null || productList.isEmpty()) {

            throw new Exception();
        }

        AtomicReference<Float> total = new AtomicReference();
        total.set(0F);

        productList.stream().forEach(itera -> {total.set(total.get() + returnValues.get(itera));
            productRepository.AddItemToCache(itera);
        });

        Response response = new Response(total.get(),productList );
        return response;
    }

    public HashMap<String, Integer> getTopItems(){
        return productRepository.GetTopItems();
    }

    private String getIds(Set<String> ids) {
        int count = 1;

        StringBuilder tempList = new StringBuilder();
        for (String cycle : ids) {

            if (count == 1) {
                tempList.append(cycle);
            } else {

                tempList.append(",").append(cycle);
            }
            count++;
        }

        return tempList.toString();
    }
    private List<String> calculate(Map<String, Float> items, Float amount) {

        List<String> itemsSelected = new ArrayList();
        AtomicReference<Float> total = new AtomicReference();
        total.set(0F);

        items.entrySet().stream().sorted((v1, v2) -> v1.getValue().compareTo(v2.getValue())).forEachOrdered(item -> {

            total.set(total.get() + item.getValue() ) ;

            if(total.get() < amount ) {

                itemsSelected.add(item.getKey());

            }else {
                return;
            }

        });

        return itemsSelected;


    }

}
