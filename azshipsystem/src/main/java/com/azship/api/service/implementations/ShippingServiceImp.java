package com.azship.api.service.implementations;

import com.azship.api.domain.entity.Shipping;
import com.azship.api.domain.enums.ShippingType;
import com.azship.api.domain.resource.request.ShippingRegisterRequest;
import com.azship.api.domain.resource.request.ShippingUpdateRequest;
import com.azship.api.infra.repository.ShippingRepository;
import com.azship.api.service.ShippingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShippingServiceImp implements ShippingService {

    private final UserServiceImp userServiceImp;
    private final ShippingRepository shippingRepository;
    @Override
    public Shipping registerShipping(ShippingRegisterRequest data) {
        var shipping = new Shipping();
        var user = userServiceImp.getUserById(data.userId());
        shipping.setUser(user);
        shipping.setHashCode(this.generateHashCode());
        this.setProperties(shipping, data);

        return shippingRepository.save(shipping);
    }

    @Override
    public List<Shipping> getAllByUserId(Long userId) {
        return null;
    }

    @Override
    public Shipping updateShipping(ShippingUpdateRequest data) {
        return null;
    }

    @Override
    public void deleteShipping(Long id) {

    }
    public String generateHashCode() {
        return UUID.randomUUID().toString();
    }

    public void setProperties(Shipping shipping, ShippingRegisterRequest data){
        List<Field> fields = List.of(Shipping.class.getDeclaredFields());
        data.shippingProperties().forEach((fieldName, value) -> {
            if(this.containsField(fieldName, fields) && !value.isEmpty()){
                this.setFieldValue(shipping, fieldName, value);
            }
        });
    }
    public Boolean containsField(String fieldName, List<Field> fields) {
        return fields.stream().anyMatch(field -> field.getName().equals(fieldName));
    }

    public void setFieldValue(Shipping shipping, String fieldName, String value) {
        try {
            Field field = Shipping.class.getDeclaredField(fieldName);
            field.setAccessible(true);

            switch(fieldName){
                case "totalWeight" -> shipping.setTotalWeight(Double.parseDouble(value));
                case "totalVolume" -> shipping.setTotalVolume(Double.parseDouble(value));
                case "totalPacks" -> shipping.setTotalPacks(Integer.parseInt(value));
                case "type" -> {
                    ShippingType type = ShippingType.valueOf(value.toUpperCase());
                    shipping.setType(type);
                }
                case "deliveryDate" -> {
                    var deliveryDate = LocalDate.parse(value);
                    shipping.setDeliveryDate(deliveryDate);
                }
                default -> field.set(shipping, value);
            }

        } catch (NoSuchFieldException e) {
            System.err.println("Erro: Campo '" + fieldName + "' não encontrado em Shipping.");
        } catch (IllegalAccessException e) {
            System.err.println("Erro: Acesso ilegal ao campo '" + fieldName + "' em Shipping.");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: Valor inválido para o campo '" + fieldName + "' em Shipping.");
        }
    }


}
