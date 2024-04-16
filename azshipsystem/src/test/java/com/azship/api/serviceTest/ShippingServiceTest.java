package com.azship.api.serviceTest;

import com.azship.api.domain.entity.Shipping;
import com.azship.api.domain.entity.User;
import com.azship.api.domain.enums.ShippingType;
import com.azship.api.domain.resource.request.ShippingRegisterRequest;
import com.azship.api.infra.repository.ShippingRepository;
import com.azship.api.infra.repository.UserRepository;
import com.azship.api.service.implementations.ShippingServiceImp;
import com.azship.api.service.implementations.UserServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShippingServiceTest {

    private ShippingRegisterRequest request;

    private Shipping expectedShipping;

    @Mock
    private UserServiceImp userService;

    @Mock
    private ShippingRepository shippingRepository;

    @InjectMocks
    private ShippingServiceImp shippingService;

    @BeforeEach
    void setUp() {
        expectedShipping = new Shipping();
        expectedShipping.setId(1L);
        expectedShipping.setUser(mockUser());
        expectedShipping.setTotalWeight(10.5);
        expectedShipping.setTotalPacks(3);
        expectedShipping.setType(ShippingType.EXPRESS);
        expectedShipping.setDeliveryDate(LocalDate.parse("2022-12-31"));

        HashMap<String, String> shippingProperties = new HashMap<>();
        shippingProperties.put("totalWeight", "10.5");
        shippingProperties.put("totalPacks", "3");
        shippingProperties.put("type", "EXPRESS");
        shippingProperties.put("deliveryDate", "2022-12-31");
        request = new ShippingRegisterRequest(1L, shippingProperties);
   }
    @Test
    void testGivenShippingRegisterRequestObg_WhenSaveShipping_thenReturnShippingObj(){
        given(userService.getUserById(request.userId())).willReturn(mockUser());
        given(shippingRepository.save(any(Shipping.class))).willReturn(expectedShipping);

        Shipping savedShipping = shippingService.registerShipping(request);

        Assertions.assertNotNull(savedShipping);
        Assertions.assertTrue(savedShipping.getId() > 0);
        Assertions.assertEquals(expectedShipping.getUser(), savedShipping.getUser());
        Assertions.assertEquals(expectedShipping.getTotalWeight(), savedShipping.getTotalWeight());
        assertThat(expectedShipping.getTotalPacks()).isEqualByComparingTo(savedShipping.getTotalPacks());
        assertThat(expectedShipping.getDeliveryDate()).isEqualTo(savedShipping.getDeliveryDate());

        verify(userService, times(1)).getUserById(1L);
        verify(shippingRepository, times(1)).save(any(Shipping.class));

    }

    private User mockUser() {
        User user = new User();
        user.setId(1L);
        return user;
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
