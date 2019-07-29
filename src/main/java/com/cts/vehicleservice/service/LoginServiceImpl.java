package com.cts.vehicleservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.vehicleservice.dao.LoginRepository;
import com.cts.vehicleservice.model.Login;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private LoginRepository loginRepo;
	
	@Override
	public boolean validateUser(Login login) {

		boolean isValidUser=false;
		System.out.println("inside service impl...."+login.getUserName()+ login.getPassword());
		List<Login>list=loginRepo.findByUserNameAndPassword(login.getUserName(), login.getPassword());
		if(list.size() > 0) {
			
			isValidUser=true;
		}
		return isValidUser;
	}


	@Override
	public void saveUserLogin(String userName,Integer userId, String password,String userType) {
		Login login=new Login();
		login.setUserName(userName);
		login.setUserId(userId);
		login.setPassword(password);
		login.setUserType(userType);
		loginRepo.save(login);
		
	}


}