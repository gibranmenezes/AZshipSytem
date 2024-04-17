package com.azship.api.domain.shipping;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection  = "shippings")
public class Shipping {

    @Id
    private String id;
    private String code;
    private String userId;
    private String postalCode;
    private Double weight;
    private Double volume;
    private ShippingType type;
    private LocalDate deliveryDate;
    private Integer packAmount;

    public Shipping(ShippingRequest data){
        this.type = data.type();
        this.deliveryDate = data.deliveryDate();
        this.postalCode = data.postalCode();
        this.volume = data.volume();
        this.weight = data.weight();
    }


}
