package com.mabdoh.order.service.domain.usecase.order.track.query;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class TrackOrderQuery {
    
    @NotNull
    private final UUID orderTrackingId;
}
