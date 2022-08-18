package com.meli.demo.services.product;

import java.util.Map;

public interface IProductConsumer {
    Map<String, Float> getProductPrices(String ids);
}
