package com.mabdoh.order.service.domain;

import java.util.List;

import com.mabdoh.order.service.domain.entity.Order;
import com.mabdoh.order.service.domain.entity.Restaurant;
import com.mabdoh.order.service.domain.event.OrderWasCancelledEvent;
import com.mabdoh.order.service.domain.event.OrderWasCreatedEvent;
import com.mabdoh.order.service.domain.event.OrderWasPaidEvent;

public interface OrderDomainService {
    
    OrderWasCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderWasPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderWasCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
    
}
