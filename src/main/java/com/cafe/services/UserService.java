package com.cafe.services;

import java.util.List;

import org.apache.coyote.BadRequestException;

import com.cafe.request.RegistrationRequest;
import com.cafe.response.UserResponse;

public interface UserService {

	void signUp(RegistrationRequest request) throws Exception;

	List<UserResponse> fetchAll();

	UserResponse fetchUserById(Integer userId) throws BadRequestException;

	void updateUser(Integer userId, RegistrationRequest request) throws BadRequestException;

}
