package com.cafe.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.request.RegistrationRequest;
import com.cafe.response.ResponseMessage;
import com.cafe.response.UserResponse;
import com.cafe.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/signup")
	public ResponseEntity<ResponseMessage<String>> signUp(@RequestBody RegistrationRequest request) throws Exception{
		log.info("Inside sign up ");	
		userService.signUp(request);
		return ResponseEntity.ok(new ResponseMessage<String>("1","User registered successfully"));
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseMessage<List<UserResponse>>>fetchAllUsers(){
		log.info("Inside fetch all api");
		return ResponseEntity.ok(new ResponseMessage<List<UserResponse>>("1", userService.fetchAll()));
	}
	
	@GetMapping("fetchUser/{userId}")
	public ResponseEntity<ResponseMessage<UserResponse>> fetchUserById(@PathVariable Integer userId) throws BadRequestException{
		return ResponseEntity.ok(new ResponseMessage<UserResponse>("1",userService.fetchUserById(userId)));
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<ResponseMessage<String>> updateUser(@PathVariable Integer userId, @RequestBody RegistrationRequest request) throws BadRequestException{
		userService.updateUser(userId,request);
		System.out.println("This is ok yr ");
		System.out.println("This is not ok yrr");
		return ResponseEntity.ok(new ResponseMessage("1","User update successfully"));
	}
}
