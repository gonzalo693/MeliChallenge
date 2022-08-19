package com.meli.demo.services.product;

import net.minidev.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * This class represents a service used to invoke MELI's Items API to make the request and process the response.
 */

@Service
public class ProductConsumer implements IProductConsumer{


    private final String url = "https://api.mercadolibre.com/items?ids=";

    /**
     *  Invokes MELI's Items API with the given item IDs to retrieve each item's price
     * */
    public Map<String, Float> getProductPrices(String ids) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Float> returnValues = new HashMap();

        ResponseEntity<JSONArray> response = restTemplate.getForEntity(url+ids,
                JSONArray.class);
        JSONArray products = response.getBody();

        products.stream().forEach(itera -> {

            LinkedHashMap<String, Object> product = (LinkedHashMap) itera;
            if("200".equals(String.valueOf(product.get("code")))) {
                LinkedHashMap<String, Object> body = (LinkedHashMap)product.get("body");
                returnValues.put((String)body.get("id"), Float.valueOf(String.valueOf(body.get("price"))));

            }
        });

        return returnValues;

    }

}

