package com.azship.api.domain.shipping.resource.response;

import com.azship.api.domain.shipping.Shipping;
import com.azship.api.domain.shipping.ShippingType;

import java.time.LocalDate;

public record ShippingResponse(String shippingId, String userId, String code, Double weight, Double volume
        , Integer packAmount, LocalDate deliveryDate, ShippingType type) {
    public ShippingResponse(Shipping shipping){
        this(shipping.getId(), shipping.getUserId(), shipping.getCode(), shipping.getWeight(), shipping.getVolume(),
                shipping.getPackAmount(), shipping.getDeliveryDate(), shipping.getType());
    }
}
