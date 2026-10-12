package com.smarthire.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.smarthire.dto.LoginRequest;
import com.smarthire.dto.LoginResponse;
import com.smarthire.repository.AppUserRepository;
import com.smarthire.security.JwtService;
import com.smarthire.service.LoginService;
import com.smarthire.entity.AppUser;
import com.smarthire.repository.AppUserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	private final AppUserRepository appUserRepository;

	public LoginServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService,
			AppUserRepository appUserRepository) {

		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
		this.appUserRepository = appUserRepository;
	}

	@Override
	public LoginResponse login(LoginRequest request) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		AppUser user = appUserRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));

		String token = jwtService.generateToken(request.getEmail());

		return new LoginResponse(token, user.getEmail(), user.getRole());
	}
}