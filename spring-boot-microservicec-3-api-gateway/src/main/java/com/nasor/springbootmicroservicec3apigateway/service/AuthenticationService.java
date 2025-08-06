package com.nasor.springbootmicroservicec3apigateway.service;

import com.nasor.springbootmicroservicec3apigateway.model.User;

public interface AuthenticationService {
    User sigInAndReturnJWT(User signInRequest);
}
