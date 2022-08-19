package com.meli.demo.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.meli.demo.services.bean.Product;

import java.util.List;

public class ResponseProduct {

    @JsonAlias("item_ids")
    private List<Product> products;

    public ResponseProduct(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
