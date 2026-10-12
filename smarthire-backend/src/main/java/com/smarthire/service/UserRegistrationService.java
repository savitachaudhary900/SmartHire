package com.smarthire.service;

import com.smarthire.dto.UserRegistrationRequest;
import com.smarthire.dto.UserRegistrationResponse;

public interface UserRegistrationService {

    UserRegistrationResponse registerUser(
            UserRegistrationRequest request);
}