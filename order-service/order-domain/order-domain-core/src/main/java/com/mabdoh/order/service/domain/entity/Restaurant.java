package com.mabdoh.order.service.domain.entity;

import java.util.List;

import com.mabdoh.domain.entity.AggregateRoot;
import com.mabdoh.domain.valueobject.RestaurantId;

public class Restaurant extends AggregateRoot<RestaurantId> {
    private final List<Product> products;
    private boolean active;

    public Restaurant(List<Product> products, boolean active) {
        this.products = products;
        this.active = active;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isActive() {
        return active;
    }
}
