package com.mabdoh.order.service.domain.event;

import com.mabdoh.domain.event.DomainEvent;
import com.mabdoh.order.service.domain.entity.Order;

public class OrderWasCancelledEvent extends DomainEvent<Order> {

    public OrderWasCancelledEvent(Order order) {
        super(order);
    }
    
}
