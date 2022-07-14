package com.mabdoh.order.service.domain.valueobject;

import java.util.UUID;

import com.mabdoh.domain.valueobject.BaseId;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
