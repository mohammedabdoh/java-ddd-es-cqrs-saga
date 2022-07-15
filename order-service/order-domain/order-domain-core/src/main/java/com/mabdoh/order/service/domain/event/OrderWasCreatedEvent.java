package com.mabdoh.order.service.domain.event;

import com.mabdoh.domain.event.DomainEvent;
import com.mabdoh.order.service.domain.entity.Order;

public class OrderWasCreatedEvent extends DomainEvent<Order> {
    public OrderWasCreatedEvent(Order order) {
        super(order);
    }
}
