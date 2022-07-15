package com.mabdoh.domain.event;

import java.time.ZonedDateTime;

public abstract class DomainEvent<T> {
    private final T entity;
    private final static ZonedDateTime createdAt = ZonedDateTime.now();

    public DomainEvent(T entity) {
        this.entity = entity;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public T getEntity() {
        return entity;
    }
}
