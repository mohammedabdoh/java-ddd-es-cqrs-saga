package com.mabdoh.order.service.domain.usecase.order.track.response;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.mabdoh.domain.valueobject.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class TrackOrderResponse {

    @NotNull
    private final UUID orderTrackingId;

    @NotNull
    private final OrderStatus orderStatus;
    
    private final List<String> failureMessages;
}
