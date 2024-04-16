package com.azship.api.domain.shipping.resource.response;

import com.azship.api.domain.shipping.ShippingType;

import java.time.LocalDate;

public record ShippingResponse(String shippingId, String userId, String code, Double weight, Double volume, Integer packAmount, LocalDate deliveryDate, ShippingType type) {
}
