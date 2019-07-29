package com.cts.vehicleservice.service;

import com.cts.vehicleservice.model.Login;

public interface ILoginService {
	
	void saveUserLogin(String userName,Integer userId,String password,String userType);
	
	boolean validateUser(Login login);

}