package com.smarthire.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smarthire.dto.UserRegistrationRequest;
import com.smarthire.dto.UserRegistrationResponse;
import com.smarthire.entity.AppUser;
import com.smarthire.repository.AppUserRepository;
import com.smarthire.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl
        implements UserRegistrationService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationServiceImpl(
            AppUserRepository appUserRepository,
            PasswordEncoder passwordEncoder) {

        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserRegistrationResponse registerUser(
            UserRegistrationRequest request) {

        AppUser user = new AppUser();

        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(request.getPassword()));

        user.setRole(request.getRole());

        AppUser savedUser =
                appUserRepository.save(user);

        return new UserRegistrationResponse(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getRole());
    }
}