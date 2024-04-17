package com.azship.api.domain.validations.shipping;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import jakarta.xml.bind.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class FieldsNullValidation implements CreateShippingValidator {
    @Override
    public void validate(ShippingRequest data) throws ValidationException {
        if(this.allFieldsAreNullOrBlank(data)) {
            throw new ValidationException(("A least one field is required"));
        }

    }
    private boolean allFieldsAreNullOrBlank(ShippingRequest request) {

        return request.type() == null
                && request.deliveryDate() == null
                && request.packAmount() == null
                && request.weight() == null
                && request.volume() == null;
    }

}
