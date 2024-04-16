package com.azship.api.domain.shipping;

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


}
