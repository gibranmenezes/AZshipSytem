package com.azship.api.service.imp;

import com.azship.api.domain.shipping.Shipping;
import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import com.azship.api.domain.shipping.resource.response.ShippingResponse;
import com.azship.api.infra.repository.ShippingRepository;
import com.azship.api.infra.repository.UserRepository;
import com.azship.api.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShippingServiceImp implements ShippingService {

    private final ShippingRepository shippingRepository;
    private final UserRepository userRepository;

    @Override
    public ShippingResponse create(ShippingRequest request) {
        // Verificar se o usuário com o userId fornecido existe
        var user = userRepository.findById(request.userID())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

       Shipping shipping = Shipping.builder()
                .type(request.type())
                .deliveryDate(request.deliveryDate())
                .volume(request.volume())
                .weight(request.weight())
                .build();

        shipping.setCode(generateCode());
        shipping.setUserId(user.getId());

        var savedShipping = shippingRepository.save(shipping);

        return mapToShippingResponse(savedShipping);
    }

    @Override
    public List<ShippingResponse> getAllByUserId(String userId) {
        // Implementar a lógica para buscar todos os shippings associados a um usuário
        // Você pode usar userRepository para encontrar o usuário pelo userId e obter a lista de shippings
        return null;
    }

    private String generateCode() {
        return UUID.randomUUID().toString();
    }


}
