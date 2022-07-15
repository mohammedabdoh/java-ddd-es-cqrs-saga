package com.mabdoh.order.service.domain;

import java.util.List;

import com.mabdoh.order.service.domain.entity.Order;
import com.mabdoh.order.service.domain.entity.Product;
import com.mabdoh.order.service.domain.entity.Restaurant;
import com.mabdoh.order.service.domain.event.OrderWasCancelledEvent;
import com.mabdoh.order.service.domain.event.OrderWasCreatedEvent;
import com.mabdoh.order.service.domain.event.OrderWasPaidEvent;
import com.mabdoh.order.service.domain.exception.OrderDomainException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {

    @Override
    public void approveOrder(Order order) {
        order.approve();

        log.info("Order with id %s has been approved", order.getId().getValue());
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);

        log.info("Order with id %s has been cancelled", order.getId().getValue());
    }

    @Override
    public OrderWasCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);

        log.info("Order payment is cancelling for order id %s", order.getId().getValue());

        return new OrderWasCancelledEvent(order);
    }

    @Override
    public OrderWasPaidEvent payOrder(Order order) {
        order.pay();

        log.info(String.format("Order with id %s has been paid", order.getId().getValue()));
        
        return new OrderWasPaidEvent(order);
    }

    @Override
    public OrderWasCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant) {
        validateRestaurant(restaurant);
        setOrderProductInformation(order, restaurant);

        order.validateOrder();
        order.initializeOrder();

        log.info(String.format("Order with the id %s has been initiated", order.getId().getValue()));

        return new OrderWasCreatedEvent(order);
    }

    private void setOrderProductInformation(Order order, Restaurant restaurant) {
        order.getItems().forEach(orderItem -> restaurant.getProducts().forEach(restaurantProduct -> {
            Product currentProduct = orderItem.getProduct();
            if(currentProduct.equals(restaurantProduct)) {
                currentProduct.updateWithConfirmedNameAndPrice(restaurantProduct.getName(), restaurantProduct.getPrice());
            }
        }));
    }

    private void validateRestaurant(Restaurant restaurant) {
        if(!restaurant.isActive()) {
            throw new OrderDomainException(
                String.format("Restaurant with id %s is not active", restaurant.getId().getValue())
            );
        }
    }
    
}
