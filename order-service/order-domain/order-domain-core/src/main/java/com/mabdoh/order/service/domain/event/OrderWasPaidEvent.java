package com.mabdoh.order.service.domain.event;

import com.mabdoh.domain.event.DomainEvent;
import com.mabdoh.order.service.domain.entity.Order;

public class OrderWasPaidEvent extends DomainEvent<Order> {

    public OrderWasPaidEvent(Order order) {
        super(order);
    }
    
}
