package com.nasor.springbootmicroservicec3apigateway.service;

import com.nasor.springbootmicroservicec3apigateway.model.Role;
import com.nasor.springbootmicroservicec3apigateway.model.User;
import com.nasor.springbootmicroservicec3apigateway.repository.UserRepository;
import com.nasor.springbootmicroservicec3apigateway.security.jwt.JwtProvider;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public User saveUser(User user) {
        user.setFechaCreacion(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        User createdUser = userRepository.save(user);

        String jwt = jwtProvider.generateToken(createdUser);

        createdUser.setToken(jwt);

        return createdUser;
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void updateRole(Role newRole, String username){
        userRepository.updateUserRole(username, newRole);
    }

    @Override
    public User findByUsernameReturnToken(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        String jwt = jwtProvider.generateToken(user);
        user.setToken(jwt);
        return user;
    }
}
