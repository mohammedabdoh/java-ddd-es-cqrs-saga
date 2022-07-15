package com.mabdoh.order.service.domain.port.output.message.publisher.restaurantapproval;

import com.mabdoh.domain.event.publisher.DomainEventPublisher;
import com.mabdoh.order.service.domain.event.OrderWasPaidEvent;

public interface OrderPaidRestaurantApprovalRequestMessagePublisher extends DomainEventPublisher<OrderWasPaidEvent> {
    
}
