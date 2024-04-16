package com.azship.api.domain.resource.response;

import com.azship.api.domain.entity.Shipping;
import com.azship.api.domain.enums.ShippingType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public record ShippingListingResponse(Long shippingId, String hasCode, String postalCode, ShippingType type, Double totalWeight,
                                      Double totalVolume, Integer totalPacks, LocalDate deliveryDate) {

    public ShippingListingResponse(Shipping shipping){
        this(shipping.getId(), shipping.getHashCode(), shipping.getPostalCode(), shipping.getType(), shipping.getTotalWeight(), shipping.getTotalVolume(), shipping.getTotalPacks(), shipping.getDeliveryDate());
    }
}
