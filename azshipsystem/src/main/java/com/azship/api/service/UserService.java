package com.azship.api.service;

import com.azship.api.domain.entity.User;
import com.azship.api.domain.resource.request.UserUptadeRequest;

public interface UserService {

    User getUserById(Long id);

    User updateUser(UserUptadeRequest data);

}
