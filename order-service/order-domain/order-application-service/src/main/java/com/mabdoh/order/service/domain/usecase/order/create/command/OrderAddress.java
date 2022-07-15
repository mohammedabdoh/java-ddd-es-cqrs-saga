package com.mabdoh.order.service.domain.usecase.order.create.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class OrderAddress {
    
    @NotNull
    @Max(value = 50)
    private final String street;

    @NotNull
    @Max(value = 50)
    private final String city;

    @NotNull
    @Max(value = 10)
    private final String postalCode;
}
