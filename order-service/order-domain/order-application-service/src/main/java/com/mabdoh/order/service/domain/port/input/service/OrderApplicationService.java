package com.mabdoh.order.service.domain.port.input.service;

import javax.validation.Valid;

import com.mabdoh.order.service.domain.usecase.order.create.command.CreateOrderCommand;
import com.mabdoh.order.service.domain.usecase.order.create.response.CreateOrderResponse;
import com.mabdoh.order.service.domain.usecase.order.track.query.TrackOrderQuery;
import com.mabdoh.order.service.domain.usecase.order.track.response.TrackOrderResponse;

public interface OrderApplicationService {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand command);
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery query);
}
