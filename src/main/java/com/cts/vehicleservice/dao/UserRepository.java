package com.cts.vehicleservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.vehicleservice.model.User;


public interface UserRepository  extends JpaRepository<User, String>{
	List<User> findAllByUserId(String userId);

}