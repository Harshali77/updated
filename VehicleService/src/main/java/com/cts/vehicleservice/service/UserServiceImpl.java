package com.cts.vehicleservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.vehicleservice.dao.UserRepository;
import com.cts.vehicleservice.model.SpareParts;
import com.cts.vehicleservice.model.User;
 
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository UserRepo;
	
	@Override
	public SpareParts savePart(SpareParts SpareParts) {
		System.out.println("Inside crud repo...");
		if(SpareParts!=null ) {
			System.out.println("New Part...");
			
			try {
				SpareParts=UserRepo.save(SpareParts);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SpareParts;
	}

	@Override
	public boolean deletePart(String partId) {
		boolean isDeleted=false;
		if(null!=partId && UserRepo.existsById(partId)) {
			UserRepo.deleteById(partId);
			isDeleted=true;
		}
		
		return isDeleted;
	}

	@Override
	public SpareParts getPart(String partId) {
		
		System.out.println("*******IN SERVICE IMPL**********");
		
		SpareParts User=null;
		if (UserRepo.existsById(partId)) {
			User=UserRepo.findById(partId).get();
			
		}
		
		return User;
	}

	@Override
	public List<SpareParts> getAllParts() {
		
		return UserRepo.findAll();
	}

	
	
	

}
