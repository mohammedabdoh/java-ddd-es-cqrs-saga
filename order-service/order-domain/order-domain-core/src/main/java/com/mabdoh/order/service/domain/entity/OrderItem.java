package com.mabdoh.order.service.domain.entity;

import com.mabdoh.domain.entity.BaseEntity;
import com.mabdoh.domain.valueobject.Money;
import com.mabdoh.domain.valueobject.OrderId;
import com.mabdoh.order.service.domain.valueobject.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private final Product product;
    private final int quantity;
    private final Money price;
    private final Money subTotal;

    public OrderItem(Product product, int quantity, Money price, Money subTotal) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
    }

    public OrderId getOrderId() {
        return this.orderId;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Money getPrice() {
        return this.price;
    }

    public Money getSubTotal() {
        return this.subTotal;
    }

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        this.orderId = orderId;
        setId(orderItemId);
    }

    boolean isPriceValid() {
        return price.isGreaterThanZero() && price.equals(product.getPrice()) && price.multiply(quantity).equals(subTotal);
    }
}
