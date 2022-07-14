package com.mabdoh.order.service.domain.valueobject;

import java.util.UUID;

import com.mabdoh.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<UUID> {
    public OrderItemId(UUID value) {
        super(value);
    }    
}
