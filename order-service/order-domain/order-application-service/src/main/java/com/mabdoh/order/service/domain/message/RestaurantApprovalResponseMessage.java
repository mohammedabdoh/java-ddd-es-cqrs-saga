package com.mabdoh.order.service.domain.message;

import java.time.Instant;
import java.util.List;

import com.mabdoh.domain.valueobject.OrderApprovalStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class RestaurantApprovalResponseMessage {
    private String id;
    private String sagaId;
    private String restaurantId;
    private String orderId;
    private Instant createdAt;
    private OrderApprovalStatus orderApprovalStatus;
    private List<String> failureMessages;
}
