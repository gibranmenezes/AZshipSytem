package com.azship.api.service;

import com.azship.api.domain.entity.Shipping;
import com.azship.api.domain.resource.request.ShippingRegisterRequest;
import com.azship.api.domain.resource.request.ShippingUpdateRequest;
import com.azship.api.domain.resource.response.ShippingListingResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShippingService {
    Shipping registerShipping(Long userId, ShippingRegisterRequest data);
    Page<ShippingListingResponse> findAllByUserId(Long userId, Pageable pagination);
    Shipping updateShipping(ShippingUpdateRequest data);
    void deleteShipping(Long id);
}
