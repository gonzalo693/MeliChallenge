package com.meli.demo.repository;

import com.meli.demo.services.bean.Product;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/** This Class is in charge of store the Items used in coupons in order to handle and show the Top favourites  */
@Repository
public class ProductRepository {
    private static List<Product> cachedItems = new ArrayList<Product>();

 /**
  * This method add the items to a List for every coupon call and count if the customer call more than one time each item */
    public void AddItemToCache(String itemId) {
        Optional<Product> existingItem = cachedItems.stream().filter(i -> i.getItemId().equals(itemId)).findFirst();
        if(!existingItem.isPresent()){
            cachedItems.add(new Product(itemId,0));
        }else{
            existingItem.get().setCounter(existingItem.get().getCounter()+1);
        }
    }

    /**
     * Obtain a List of Top 5  favourites items based on the previous call to  coupon Api
     * */
    public HashMap<String, Integer> GetTopItems() {
        HashMap<String, Integer> items = cachedItems.stream().filter(i -> i.getCounter() > 0)
                .sorted(Comparator.comparingInt(e -> -e.getCounter())).limit(5)
                .collect(Collectors.toMap(Product::getItemId, Product::getCounter, (a, b) -> {
                    throw new AssertionError();
                }, LinkedHashMap::new));

        return items;
    }
}
