package com.azship.api.domain.shipping.resource.request;

import com.azship.api.domain.shipping.ShippingType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ShippingRequest(@NotNull String userID, Double weight, Double volume,
                              Integer packAmount, LocalDate deliveryDate, ShippingType type) {
}
