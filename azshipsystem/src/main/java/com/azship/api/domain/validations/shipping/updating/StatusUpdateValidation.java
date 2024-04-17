package com.azship.api.domain.validations.shipping.updating;

import com.azship.api.domain.shipping.Status;
import com.azship.api.domain.shipping.resource.request.StatusUpdatingRequest;
import com.azship.api.infra.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class StatusUpdateValidation implements UpdatingShippingValidator{
    private final ShippingRepository repository;

    @Override
    public void validate(StatusUpdatingRequest request ) {
        var shipping = repository.findShippingById(request.id());
        if (request.status().equals(Status.SENT)){
            shipping.setSendDate(LocalDate.now());
        }
        if (request.status().equals(Status.DELIVERED)){
            shipping.setDeliveryDate(LocalDate.now());
        }

    }
}
