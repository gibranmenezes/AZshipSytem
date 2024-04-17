package com.azship.api.controller;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.domain.shipping.resource.request.StatusUpdatingRequest;
import com.azship.api.domain.shipping.resource.response.ShippingResponse;
import com.azship.api.domain.shipping.resource.response.StatusUpdateResponse;
import com.azship.api.service.imp.ShippingServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shippings")
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingServiceImp serviceImp;

    @PostMapping()
    public ResponseEntity<ShippingResponse> create(@RequestBody ShippingRequest request){
            return ResponseEntity.ok(serviceImp.create(request));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Page<ShippingResponse>> getAll(@PathVariable String userId
            , @PageableDefault(size = 10, sort = {"id"}) Pageable pagination) {
        return ResponseEntity.ok(serviceImp.getAllByUserId(userId, pagination));
    }
    @PutMapping()
    public ResponseEntity<StatusUpdateResponse> updateStatus(StatusUpdatingRequest request){
        return ResponseEntity.ok(serviceImp.updateStatus(request));
    }

}
