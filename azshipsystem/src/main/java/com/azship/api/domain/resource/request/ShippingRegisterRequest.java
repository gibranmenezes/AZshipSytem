package com.azship.api.domain.resource.request;

import java.util.HashMap;

public record ShippingRegisterRequest(Long userID, HashMap<String, String> shippingProperties) {
}
