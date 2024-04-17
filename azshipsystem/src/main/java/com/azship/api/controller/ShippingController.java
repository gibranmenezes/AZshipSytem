package com.azship.api.controller;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.domain.shipping.resource.response.ShippingResponse;
import com.azship.api.service.imp.ShippingServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("shippings")
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingServiceImp serviceImp;

    @PostMapping()
    public ResponseEntity<ShippingResponse> create(@RequestBody ShippingRequest request){
            return ResponseEntity.ok(serviceImp.create(request));
    }


}
