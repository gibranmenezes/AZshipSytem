package com.azship.api.service;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.domain.shipping.resource.response.ShippingResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShippingService {

    ShippingResponse create(ShippingRequest request);

    Page<ShippingResponse> getAllByUserId(String userId, Pageable pagination);
}
