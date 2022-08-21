package com.meli.demo.services.product;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

class ProductConsumerTest {/*


   private static RestTemplate restTemplate = Mockito.mock(RestTemplate.class);


    private static JSONArray jsonArray;


    private ProductConsumer productConsumer = new ProductConsumer();



@Test
    void callproductConsumer_thenCheckItemFound(){
        Map<String, Float> response = productConsumer.getProductPrices("MLA811601010");
        assertNotNull(response.entrySet().stream().findFirst());
    }

    @Test
    void callMeliService_thenCheckItemNotFound(){
        Map<String, Float> response = productConsumer.getProductPrices("MLA779055077");
        assertTrue(response.entrySet().isEmpty());
    }
    @Test
    void getProductPrices() {


        try {

            JSONObject objectOne = new JSONObject();
            objectOne.put("id", "1");
            objectOne.put("title", "Test Data 1");
            objectOne.put("price", 180F);

            JSONObject objectTwo = new JSONObject();
            objectTwo.put("id", "2");
            objectTwo.put("title", "Test Data 2");
            objectTwo.put("price", 200F);

            jsonArray.put(objectTwo);
            jsonArray.put(objectOne);

            Mockito.when(restTemplate.getForEntity(anyString(), any()))
                    .thenReturn(new ResponseEntity<>(jsonArray, HttpStatus.OK));

            ProductConsumer productConsumer = new ProductConsumer();

            String ids = "1,2,3,4";

            Map<String, Float> response = productConsumer.getProductPrices(ids);
            assertEquals(response.get("1"), 180F);
            assertEquals(response.get("2"), 200F);


        } catch (Exception e) {

        }

    }
*/
}
