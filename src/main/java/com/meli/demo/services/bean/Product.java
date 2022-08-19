package com.meli.demo.services.bean;

public class Product {
    public String itemId;
    public int counter;

    public Product(String itemId, int counter) {
        this.itemId = itemId;
        this.counter = counter;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
