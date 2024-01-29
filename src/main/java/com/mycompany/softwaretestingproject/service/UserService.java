package com.mycompany.softwaretestingproject.service;

import com.mycompany.softwaretestingproject.model.User;
import com.mycompany.softwaretestingproject.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
