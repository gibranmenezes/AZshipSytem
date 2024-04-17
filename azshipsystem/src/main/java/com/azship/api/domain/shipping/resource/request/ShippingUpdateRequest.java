package com.azship.api.domain.shipping.resource.request;

import com.azship.api.domain.shipping.ShippingType;
import jakarta.validation.constraints.NotNull;

public record ShippingUpdateRequest(String id, String postalCode, Double weight, Double volume, Integer packAmount, ShippingType type) {
}
