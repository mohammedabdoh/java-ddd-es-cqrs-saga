package com.mabdoh.order.service.domain.port.output.repository;

import java.util.Optional;

import com.mabdoh.order.service.domain.entity.Order;
import com.mabdoh.order.service.domain.valueobject.TrackingId;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findOrderByTrackingId(TrackingId trackingId);
}
