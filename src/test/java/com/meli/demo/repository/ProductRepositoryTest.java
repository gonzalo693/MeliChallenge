package com.meli.demo.repository;

import com.meli.demo.services.bean.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private static List<Product> cachedItems = new ArrayList<Product>();

    @BeforeAll
    public static void setup(){
        cachedItems.add(0,new Product("MLA1",12));
        cachedItems.add(1,new Product("MLA2",4));
        cachedItems.add(2,new Product("MLA3",6));
        cachedItems.add(3,new Product("MLA4",1));
        cachedItems.add(4,new Product("MLA5",8));
    }


}