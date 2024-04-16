package com.azship.api.service;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.domain.shipping.resource.response.ShippingResponse;

import java.util.List;

public interface ShippingService {

    ShippingResponse create(ShippingRequest request);

    List<ShippingResponse> getAllByUserId(String userId);
}
