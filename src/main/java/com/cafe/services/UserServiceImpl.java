package com.cafe.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.entity.Users;
import com.cafe.repository.UserRepository;
import com.cafe.request.RegistrationRequest;
import com.cafe.response.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void signUp(RegistrationRequest request) throws Exception {
		
		if(userRepository.existsByContactNumber(request.getContactNumber()))
			throw new BadRequestException("Contact number already exists!");
		if(userRepository.existsByEmail(request.getEmail()))
			throw new BadRequestException("Email id already exists");
		Users user = new Users(request);
		userRepository.save(user);
		
	}

	@Override
	public List<UserResponse> fetchAll() {
		
		Stream<Users> userStream = userRepository.findAll().stream();
		return userStream.map(user -> new UserResponse(user))
						.collect(Collectors.toList());
		
	}

	@Override
	public UserResponse fetchUserById(Integer userId) throws BadRequestException {
		return userRepository.findById(userId)
				.map(user -> new UserResponse(user))
					.orElseThrow(()-> new BadRequestException("User not found"));
	}

	@Override
	public void updateUser(Integer userId,RegistrationRequest request) throws BadRequestException {

		Users user = userRepository.findById(userId)
				.orElseThrow(()->  new BadRequestException("User not found"));
		
		user.setContactNumber(request.getContactNumber());
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		user.setStatus(request.getStatus());
		
		userRepository.save(user);
		
	}

}
