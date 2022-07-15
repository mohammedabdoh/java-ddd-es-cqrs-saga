package com.mabdoh.domain.event.publisher;

import com.mabdoh.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
