package com.azship.api.domain.entity;

import com.azship.api.domain.enums.ShippingType;
import com.azship.api.domain.resource.request.ShippingRegisterRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name ="shippings" )
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Shipping implements Serializable {
    @Serial
    private static final long serialVersionUID = -726469762829010850L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hashCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    @JsonBackReference
    private User user;

    private String postalCode;

    private ShippingType type;

    private Double totalWeight;

    private Double totalVolume;

    private Integer totalPacks;

    private LocalDate deliveryDate;

    public Shipping(ShippingRegisterRequest data){
        this.postalCode = data.postalCode();
        this.totalVolume = data.totalVolume();
        this.totalWeight = data.totalWeight();
        this.totalPacks = data.totalPacks();
        this.type = data.type();
        this.deliveryDate = data.deliveryDate();
    }

}
