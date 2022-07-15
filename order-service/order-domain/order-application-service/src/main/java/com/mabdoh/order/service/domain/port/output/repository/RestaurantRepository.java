package com.mabdoh.order.service.domain.port.output.repository;

import java.util.Optional;

import com.mabdoh.domain.valueobject.RestaurantId;
import com.mabdoh.order.service.domain.entity.Restaurant;

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(RestaurantId restaurantId);
}
