package com.azship.api.controller;

import com.azship.api.domain.resource.request.ShippingRegisterRequest;
import com.azship.api.domain.resource.response.ShippingListingResponse;
import com.azship.api.service.implementations.ShippingServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/shippping")
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingServiceImp shippingServiceImp;

    @GetMapping("/{userId}/shipments")
    public ResponseEntity<Page<ShippingListingResponse>> getAllShippingsByUserId(@PathVariable Long userId,
                                                                                 @PageableDefault(size = 10, sort = {"hashCode"}) Pageable pagination) {
        return ResponseEntity.ok(shippingServiceImp.findAllByUserId(userId, pagination));
    }

    @PostMapping("/{userId}/shipments")
    public ResponseEntity create(@PathVariable Long userId, @RequestBody ShippingRegisterRequest data, UriComponentsBuilder uriBuilder){
        var shipping = shippingServiceImp.registerShipping(userId, data);

        var uri = uriBuilder.path("shipping/{id}").buildAndExpand(shipping.getId()).toUri();

        return ResponseEntity.created(uri).body(shipping);
    }
}
