package com.mabdoh.order.service.domain.entity;

import java.util.List;

import com.mabdoh.domain.entity.AggregateRoot;
import com.mabdoh.domain.valueobject.CustomerId;
import com.mabdoh.domain.valueobject.Money;
import com.mabdoh.domain.valueobject.OrderId;
import com.mabdoh.domain.valueobject.OrderStatus;
import com.mabdoh.domain.valueobject.RestaurantId;
import com.mabdoh.order.service.domain.valueobject.StreetAddress;
import com.mabdoh.order.service.domain.valueobject.TrackingId;

public class Order extends AggregateRoot<OrderId> {
    private final CustomerId customerId;
    private final RestaurantId restaurantId;
    private final StreetAddress streetAddress;
    private final Money price;
    private final List<OrderItem> items;

    private TrackingId trackingId;
    private OrderStatus orderStatus;
    private List<String> failureMessage;

    public Order(CustomerId customerId, RestaurantId restaurantId, StreetAddress streetAddress, Money price,
            List<OrderItem> items, TrackingId trackingId, OrderStatus orderStatus, List<String> failureMessage) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.streetAddress = streetAddress;
        this.price = price;
        this.items = items;
        this.trackingId = trackingId;
        this.orderStatus = orderStatus;
        this.failureMessage = failureMessage;
    }

    public CustomerId getCustomerId() {
        return this.customerId;
    }

    public RestaurantId getRestaurantId() {
        return this.restaurantId;
    }

    public StreetAddress getStreetAddress() {
        return this.streetAddress;
    }

    public Money getPrice() {
        return this.price;
    }

    public List<OrderItem> getItems() {
        return this.items;
    }

    public TrackingId getTrackingId() {
        return this.trackingId;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public List<String> getFailureMessage() {
        return this.failureMessage;
    }
}
