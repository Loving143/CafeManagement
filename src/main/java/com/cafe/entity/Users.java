package com.cafe.entity;

import java.io.Serializable;

import com.cafe.request.RegistrationRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class Users implements Serializable {
	
	private static final long serialversionId = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String contactNumber;
	private String email;
	private String password;
	private String status;
	private String role;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public static long getSerialversionid() {
		return serialversionId;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(RegistrationRequest request) {
		this.contactNumber = request.getContactNumber();
		this.email = request.getEmail();
		this.name = request.getName();
		this.password = request.getPassword();
		this.status = request.getStatus();
		this.role = request.getRole();
	}
	
	
			
	
	

}
