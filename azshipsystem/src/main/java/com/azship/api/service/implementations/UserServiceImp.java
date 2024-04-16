package com.azship.api.service.implementations;

import com.azship.api.domain.entity.User;
import com.azship.api.domain.resource.request.UserUptadeRequest;
import com.azship.api.infra.repository.UserRepository;
import com.azship.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User updateUser(UserUptadeRequest data) {
        return null;
    }
}
