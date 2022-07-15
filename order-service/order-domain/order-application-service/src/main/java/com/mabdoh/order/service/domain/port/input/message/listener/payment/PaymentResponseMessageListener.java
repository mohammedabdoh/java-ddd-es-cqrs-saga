package com.mabdoh.order.service.domain.port.input.message.listener.payment;

import com.mabdoh.order.service.domain.message.PaymentResponseMessage;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponseMessage paymentResponseMessage);

    void paymentCancelled(PaymentResponseMessage paymentResponseMessage);
}
