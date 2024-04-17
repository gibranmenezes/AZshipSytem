package com.azship.api.service.imp;

import com.azship.api.domain.shipping.Shipping;
import com.azship.api.domain.shipping.Status;
import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.domain.shipping.resource.request.StatusUpdatingRequest;
import com.azship.api.domain.shipping.resource.response.StatusUpdateResponse;
import com.azship.api.domain.shipping.resource.response.ShippingResponse;
import com.azship.api.domain.validations.shipping.registration.CreateShippingValidator;
import com.azship.api.domain.validations.shipping.updating.UpdatingShippingValidator;
import com.azship.api.infra.exception.ValidationException;
import com.azship.api.infra.repository.ShippingRepository;
import com.azship.api.infra.repository.UserRepository;
import com.azship.api.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingServiceImp implements ShippingService {

    private final ShippingRepository shippingRepository;
    private final UserRepository userRepository;
    private final List<CreateShippingValidator> createValidators;
    private final List<UpdatingShippingValidator> updateValidators;

    @Override
    @Transactional
    public ShippingResponse create(ShippingRequest request) {
        var user = userRepository.findById(request.userID())
                .orElseThrow(() -> new ValidationException("User not found"));

       createValidators.forEach(validator -> validator.validate(request));
       var shipping = new Shipping(request);

        shipping.generateCode();
        shipping.setUserId(user.getId());
        var savedShipping = shippingRepository.save(shipping);
        user.getShippings().add(savedShipping);
        userRepository.save(user);

        return new ShippingResponse(savedShipping);
    }

    @Override
    public Page<ShippingResponse> getAllByUserId(String userId, Pageable pagination) {
        var page = shippingRepository.findAllByUserId(userId,pagination);
        return page.map(ShippingResponse::new);

    }

    public StatusUpdateResponse updateStatus(StatusUpdatingRequest request){
        var shipping = shippingRepository.findById(request.id())
                .orElseThrow(() -> new ValidationException("User not found"));

        var newStatus = request.status();
        shipping.setStatus(newStatus);

        if ((newStatus.equals(Status.SENT))){
            shipping.setSendDate(LocalDate.now());
        }
        else if (newStatus.equals(Status.DELIVERED)){
            shipping.setDeliveryDate(LocalDate.now());
        }
        shippingRepository.save(shipping);

        return  new StatusUpdateResponse(shipping);
    }






}
