package com.azship.api.domain.shipping;

import com.azship.api.domain.shipping.resource.request.ShippingRequest;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "shippings")
public class Shipping {

    private String id;
    private String code;
    private String userId;
    private Double weight;
    private Double volume;
    private ShippingType type;
    private LocalDate deliveryDate;
    private Integer packAmount;

    public Shipping(ShippingRequest data){
        this.type = data.type();
        this.deliveryDate = data.deliveryDate();
        this.volume = data.volume();
        this.weight = data.weight();
    }


}
