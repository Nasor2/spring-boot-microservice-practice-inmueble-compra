package com.nasor.springbootmicroservicec3apigateway.service;

import com.nasor.springbootmicroservicec3apigateway.model.Role;
import com.nasor.springbootmicroservicec3apigateway.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void updateRole(Role newRole, String username);

    User findByUsernameReturnToken(String username);
}
