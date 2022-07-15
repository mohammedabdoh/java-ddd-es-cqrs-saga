package com.mabdoh.order.service.domain.entity;

import com.mabdoh.domain.entity.BaseEntity;
import com.mabdoh.domain.valueobject.Money;
import com.mabdoh.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;


    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }
    
    public Money getPrice() {
        return this.price;
    }

    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }
}
