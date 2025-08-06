package com.nasor.springbootmicroservicec3apigateway.controller;

import com.nasor.springbootmicroservicec3apigateway.model.Role;
import com.nasor.springbootmicroservicec3apigateway.model.User;
import com.nasor.springbootmicroservicec3apigateway.security.UserPrincipal;
import com.nasor.springbootmicroservicec3apigateway.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/change/{role}")
    public ResponseEntity<User> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role){
        userService.updateRole(role, userPrincipal.getUsername());
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok().body(userService.findByUsernameReturnToken(userPrincipal.getUsername()));
    }
}
