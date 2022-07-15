package com.mabdoh.order.service.domain.port.input.message.listener.restaurant;

import com.mabdoh.order.service.domain.message.RestaurantApprovalResponseMessage;

public interface RestaurantApprovalResponseMessageListener {
    
    void orderApproved(RestaurantApprovalResponseMessage responseMessage);

    void orderRejected(RestaurantApprovalResponseMessage responseMessage);
}
