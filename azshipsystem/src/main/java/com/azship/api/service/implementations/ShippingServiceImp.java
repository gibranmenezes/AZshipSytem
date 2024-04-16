package com.azship.api.service.implementations;

import com.azship.api.domain.entity.Shipping;
import com.azship.api.domain.entity.User;
import com.azship.api.domain.enums.ShippingType;
import com.azship.api.domain.resource.request.ShippingRegisterRequest;
import com.azship.api.domain.resource.request.ShippingUpdateRequest;
import com.azship.api.domain.resource.response.ShippingListingResponse;
import com.azship.api.infra.repository.ShippingRepository;
import com.azship.api.service.ShippingService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShippingServiceImp implements ShippingService {

    private final UserServiceImp userServiceImp;
    private final ShippingRepository shippingRepository;
    private static final  List<Field> fields = List.of(Shipping.class.getDeclaredFields());
    @Override
    public Shipping registerShipping(Long userId, ShippingRegisterRequest data) {
        var shipping = new Shipping(data);
        var user = userServiceImp.getUserById(userId);
        shipping.setUser(user);
        shipping.setHashCode(this.generateHashCode());
        user.addShipping(shipping);
        return shippingRepository.save(shipping);
    }

    @Override
    public Page<ShippingListingResponse> findAllByUserId(Long userId, Pageable pagination){
        var shippingPage = shippingRepository.findAllByUserId(pagination, userId);
        return shippingPage.map(ShippingListingResponse::new);

    }

    @Override
    public Shipping updateShipping(ShippingUpdateRequest data) {
        return null;
    }

    @Override
    public void deleteShipping(Long id) {

    }
    private String generateHashCode() {
        return UUID.randomUUID().toString();
    }






}
