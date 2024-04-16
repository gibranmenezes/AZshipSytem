package com.azship.api.domain.resource.request;

import com.azship.api.domain.enums.ShippingType;

import java.time.LocalDate;
import java.util.HashMap;

public record ShippingRegisterRequest(String postalCode, ShippingType type,Double totalWeight,
                                      Double totalVolume, Integer totalPacks,LocalDate deliveryDate) {


}
