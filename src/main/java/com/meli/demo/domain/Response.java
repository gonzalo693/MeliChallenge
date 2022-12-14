package com.meli.demo.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;
import java.util.List;

/**
 * This class represents a POJO for handling the Coupon API response.
 * It contains the favorite items IDs that were selected for the coupon.
 * It also contains the total amount of the coupon by adding all selected items price.
 */

public class Response implements Serializable {
    @JsonAlias("item_ids")
    private List<String> itemsIds;

    @JsonAlias("total")
    private Float total;

    public Response() {

    }

    public Response(Float total, List<String> itemsIds) {

        this.total = total;
        this.itemsIds = itemsIds;
    }

    public List<String> getItemsIds() {
        return itemsIds;
    }

    public void setItemsIds(List<String> itemsIds) {
        this.itemsIds = itemsIds;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
