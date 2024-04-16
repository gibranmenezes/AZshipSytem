package com.azship.api.infra.repository;

import com.azship.api.domain.entity.Shipping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    Page<Shipping> findAllByUserId(Pageable pagination, Long userId);
}
