package com.azship.api.service.implementations;

import com.azship.api.domain.entity.User;
import com.azship.api.domain.resource.request.UserUptadeRequest;
import com.azship.api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User updateUser(UserUptadeRequest data) {
        return null;
    }
}
