package com.cafe.response;

import com.cafe.entity.Users;

public class UserResponse {

	private Integer id;
	private String name;
	private String contactNumber;
	private String email;
	private String password;
	private String status;
	private String role; 
	
	public UserResponse(Users user) {
		this.id = user.getId();
		this.name = user.getName();
		this.contactNumber = user.getContactNumber();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.status = user.getStatus();
		this.role = user.getRole();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
