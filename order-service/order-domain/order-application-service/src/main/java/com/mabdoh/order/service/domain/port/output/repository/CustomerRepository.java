package com.mabdoh.order.service.domain.port.output.repository;

import java.util.Optional;

import com.mabdoh.domain.valueobject.CustomerId;
import com.mabdoh.order.service.domain.entity.Customer;

public interface CustomerRepository {
    Optional<Customer> findCustomer(CustomerId customerId);
}
