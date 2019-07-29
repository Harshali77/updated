package com.cts.vehicleservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.vehicleservice.dao.LoginRepository;
import com.cts.vehicleservice.dao.UserRepository;
import com.cts.vehicleservice.model.Login;
import com.cts.vehicleservice.model.User;
 
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository UserRepo;
		
	@Override
	public User saveUser(User user) {
		System.out.println("Inside crud repo...");
		if(user!=null ) {
			System.out.println("New User...");
			
			try {
				user=UserRepo.save(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public boolean deleteUser(String userId) {
		boolean isDeleted=false;
		if(null!=userId && UserRepo.existsById(userId)) {
			UserRepo.deleteById(userId);
			isDeleted=true;
		}
		
		return isDeleted;
	}

	@Override
	public User getUser(String userId) {
		
		System.out.println("*******IN SERVICE IMPL**********");
		
		User User=null;
		if (UserRepo.existsById(userId)) {
			User=UserRepo.findById(userId).get();
			
		}
		
		return User;
	}

	@Override
	public List<User> getAllUsers() {
		
		return UserRepo.findAll();
	}



	
	

}