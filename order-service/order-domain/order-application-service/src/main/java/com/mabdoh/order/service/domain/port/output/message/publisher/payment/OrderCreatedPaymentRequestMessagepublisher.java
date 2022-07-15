package com.mabdoh.order.service.domain.port.output.message.publisher.payment;

import com.mabdoh.domain.event.publisher.DomainEventPublisher;
import com.mabdoh.order.service.domain.event.OrderWasCreatedEvent;

public interface OrderCreatedPaymentRequestMessagepublisher extends DomainEventPublisher<OrderWasCreatedEvent> {

}
