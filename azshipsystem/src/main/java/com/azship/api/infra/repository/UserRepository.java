package com.azship.api.infra.repository;

import com.azship.api.domain.entity.Shipping;
import com.azship.api.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    ;
}
