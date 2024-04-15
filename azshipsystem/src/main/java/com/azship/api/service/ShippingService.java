package com.azship.api.service;

import com.azship.api.domain.entity.Shipping;
import com.azship.api.domain.resource.request.ShippingRegisterRequest;
import com.azship.api.domain.resource.request.ShippingUpdateRequest;

import java.util.List;

public interface ShippingService {
    Shipping registerShipping(ShippingRegisterRequest data);
    List<Shipping> getAllByUserId(Long userId);
    Shipping updateShipping(ShippingUpdateRequest data);
    void deleteShipping(Long id);
}
