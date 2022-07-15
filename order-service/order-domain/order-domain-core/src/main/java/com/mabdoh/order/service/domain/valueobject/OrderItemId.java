package com.mabdoh.order.service.domain.valueobject;

import com.mabdoh.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
