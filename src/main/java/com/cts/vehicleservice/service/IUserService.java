package com.cts.vehicleservice.service;

import java.util.List;

import com.cts.vehicleservice.model.User;

public interface IUserService {
	User saveUser(User user);
	boolean deleteUser(String userId);
	User getUser(String userId);
	
	List<User>getAllUsers();

}