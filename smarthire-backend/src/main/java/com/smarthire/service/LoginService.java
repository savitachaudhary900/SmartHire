package com.smarthire.service;

import com.smarthire.dto.LoginRequest;
import com.smarthire.dto.LoginResponse;

public interface LoginService {
	LoginResponse login(LoginRequest request);

}
