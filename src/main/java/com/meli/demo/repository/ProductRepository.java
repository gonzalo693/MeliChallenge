package com.meli.demo.services.repository;

import com.meli.demo.services.bean.Product;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private static List<Product> cachedItems = new ArrayList<Product>();

    public void AddItemToCache(String itemId) {
        Optional<Product> existingItem = cachedItems.stream().filter(i -> i.getItemId().equals(itemId)).findFirst();
        if(!existingItem.isPresent()){
            cachedItems.add(new Product(itemId,0));
        }else{
            existingItem.get().setCounter(existingItem.get().getCounter()+1);
        }
    }

    public HashMap<String, Integer> GetTopItems() {
        HashMap<String, Integer> items = cachedItems.stream().filter(i -> i.getCounter() > 0)
                .sorted(Comparator.comparingInt(e -> -e.getCounter())).limit(5)
                .collect(Collectors.toMap(Product::getItemId, Product::getCounter, (a, b) -> {
                    throw new AssertionError();
                }, LinkedHashMap::new));

        return items;
    }
}
