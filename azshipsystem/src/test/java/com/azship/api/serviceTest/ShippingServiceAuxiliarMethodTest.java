package com.azship.api.serviceTest;

import com.azship.api.domain.entity.Shipping;
import com.azship.api.domain.enums.ShippingType;
import com.azship.api.domain.resource.request.ShippingRegisterRequest;
import com.azship.api.service.implementations.ShippingServiceImp;
import com.azship.api.service.implementations.UserServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ShippingServiceAuxiliarMethodTest {
    @Mock
    private UserServiceImp userService;
    @InjectMocks
    private ShippingServiceImp shippingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }
    @Test
    void mustReturnIfTheRequestContainsFields() {
       var fields = this.geFields();

        Assertions.assertTrue(shippingService.containsField("totalWeight", fields));
        Assertions.assertFalse(shippingService.containsField("invalidField", fields));
    }
    @Test
    void testSetFieldValue() throws Exception {
        Shipping shipping = new Shipping();
        var request = this.getRequest();

        // Test setting totalWeight
        shippingService.setFieldValue(shipping, "totalWeight", "15.3");
        Assertions.assertEquals(15.3, shipping.getTotalWeight());

        // Test setting type
//        shippingService.setFieldValue(shipping, "type", "COMMOM");
//        Assertions.assertEquals(ShippingType.COMMOM.toString(), shipping.getType());

        // Test setting deliveryDate
        shippingService.setFieldValue(shipping, "deliveryDate", "2023-01-15");
        Assertions.assertEquals(LocalDate.parse("2023-01-15"), shipping.getDeliveryDate());
    }

    private ShippingRegisterRequest getRequest(){
        var userId = 1L;
        HashMap<String, String> shippingProperties = new HashMap<>();
        shippingProperties.put("totalWeight", "10.5");
        shippingProperties.put("totalPacks", "3");
        shippingProperties.put("type", "EXPRESS");
        shippingProperties.put("deliveryDate", "2022-12-31");
        return new ShippingRegisterRequest(userId, shippingProperties);
    }
    private List<Field> geFields(){
        return List.of(Shipping.class.getDeclaredFields());
    }


}
