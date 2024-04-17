package com.azship.api.domain.validations.shipping;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import jakarta.xml.bind.ValidationException;

public interface CreateShippingValidator {

    void validate(ShippingRequest data) throws ValidationException;


}
