package com.azship.api.infra.repository;

import com.azship.api.domain.shipping.Shipping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShippingRepository extends MongoRepository<Shipping, String> {
}
