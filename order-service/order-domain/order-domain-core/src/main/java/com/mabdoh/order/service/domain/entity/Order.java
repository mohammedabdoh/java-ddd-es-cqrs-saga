package com.mabdoh.order.service.domain.entity;

import java.util.List;
import java.util.UUID;

import com.mabdoh.domain.entity.AggregateRoot;
import com.mabdoh.domain.valueobject.CustomerId;
import com.mabdoh.domain.valueobject.Money;
import com.mabdoh.domain.valueobject.OrderId;
import com.mabdoh.domain.valueobject.OrderStatus;
import com.mabdoh.domain.valueobject.RestaurantId;
import com.mabdoh.order.service.domain.exception.OrderDomainException;
import com.mabdoh.order.service.domain.valueobject.OrderItemId;
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
    private List<String> failureMessages;

    public Order(CustomerId customerId, RestaurantId restaurantId, StreetAddress streetAddress, Money price,
            List<OrderItem> items, TrackingId trackingId, OrderStatus orderStatus, List<String> failureMessages) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.streetAddress = streetAddress;
        this.price = price;
        this.items = items;
        this.trackingId = trackingId;
        this.orderStatus = orderStatus;
        this.failureMessages = failureMessages;
    }

    public void initializeOrder() {
        setId(new OrderId(UUID.randomUUID()));
        trackingId = new TrackingId(UUID.randomUUID());
        orderStatus = OrderStatus.PENDING;
        initializeOrderItems();
    }

    public void validateOrder() {
        validateInitialOrder();
        validateTotalPrice();
        validateItemsPrice();
    }

    public void pay() {
        if (orderStatus != OrderStatus.PENDING) {
            throw new OrderDomainException("Order should be in a pending state to complete payment");
        }

        orderStatus = OrderStatus.PAID;
    }

    public void approve() {
        if (orderStatus != OrderStatus.PAID) {
            throw new OrderDomainException("Order should be paid before you approve it.");
        }

        orderStatus = OrderStatus.APPROVED;
    }

    public void initCancel(List<String> failureMessages) {
        if (orderStatus != OrderStatus.PAID) {
            throw new OrderDomainException("Order should be paid to be able to initialize a cancellation");
        }

        orderStatus = OrderStatus.CANCELLING;
        updateFailureMessage(failureMessages);
    }

    public void cancel(List<String> failureMessages) {
        if (!(orderStatus == OrderStatus.CANCELLING || orderStatus == OrderStatus.PENDING)) {
            throw new OrderDomainException("Order is not in a corrrect state to cancel it");
        }

        orderStatus = OrderStatus.CANCELLED;
        updateFailureMessage(failureMessages);
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
        return this.failureMessages;
    }

    private void initializeOrderItems() {
        long itemId = 1;
        for (OrderItem orderItem : items) {
            orderItem.initializeOrderItem(getId(), new OrderItemId(itemId++));
        }
    }

    private void validateInitialOrder() {
        if (orderStatus == null || getId() == null) {
            throw new OrderDomainException("Order is not in correct state for initialization");
        }
    }

    private void validateTotalPrice() {
        if (price == null || !price.isGreaterThanZero()) {
            throw new OrderDomainException("Total price must be greater than zero.");
        }
    }

    private void validateItemsPrice() {
        Money orderItemsTotal = items.stream().map(Order::validateItemPrice).reduce(Money.ZERO, Money::add);

        if (!price.equals(orderItemsTotal)) {
            throw new OrderDomainException(
                    String.format(
                            "Total price %i is not equal to order items total",
                            price.getAmmount(),
                            orderItemsTotal.getAmmount()));
        }
    }

    private static Money validateItemPrice(OrderItem orderItem) {
        if (!orderItem.isPriceValid()) {
            throw new OrderDomainException(
                    String.format(
                            "Order item price %i is not valid for product %s",
                            orderItem.getPrice().getAmmount(),
                            orderItem.getProduct().getId().getValue()));
        }

        return orderItem.getSubTotal();
    }

    private void updateFailureMessage(List<String> failureMessages) {
        if(failureMessages != null && this.failureMessages != null) {
            this.failureMessages.addAll(failureMessages.stream().filter(String::isEmpty).toList());
        }

        if(this.failureMessages == null) {
            this.failureMessages = failureMessages;
        }
    }
}
