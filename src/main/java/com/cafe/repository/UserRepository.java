package com.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {

	boolean existsByEmail(String email);

	boolean existsByContactNumber(String contactNumber);

}
