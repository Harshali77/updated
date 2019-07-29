package com.cts.vehicleservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.vehicleservice.model.Login;
import com.cts.vehicleservice.model.User;

import com.cts.vehicleservice.service.ILoginService;
import com.cts.vehicleservice.service.IUserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ILoginService loginService;
	
	@GetMapping("/showAllUsers")
	public ResponseEntity<List<User>> getAll() {
		
		System.out.println("In get all controller...");
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/") public ModelAndView getHome() {
	 * 
	 * return new ModelAndView("home", "home","home"); }
	 */
	 
	@GetMapping("/{userId}")
	public ResponseEntity<User>getUser(@PathVariable String userId){
		ResponseEntity<User>  response=null;
		
		User User=userService.getUser(userId);
		
		if(User!=null){
			response=new ResponseEntity<User>(User,HttpStatus.OK);
		}
		else {
			response=new ResponseEntity<User>(User,HttpStatus.NOT_FOUND);		
		}
		return response;
	}
	
	
	@PostMapping("/validate")
	public ResponseEntity<Login>validateUser(@RequestBody Login login){
		ResponseEntity<Login>  response=null;
		System.out.println("Inside validate controller....");
		
		boolean isValidUser =loginService.validateUser(login);
		
		System.out.println("response..:"+isValidUser);
		

		if (isValidUser) {
	response=new ResponseEntity<Login>(login,HttpStatus.OK);
	
}
else
{
	
	response=new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
}
		return response;
	}
	@PostMapping("/newuser")
	public ResponseEntity<User> addUser(@RequestBody User User){
		
		System.out.println("Inside add user....");
		
		ResponseEntity<User> response=null;
		User respUser=userService.saveUser(User);
		loginService.saveUserLogin(User.getUserName(),User.getUserId(),User.getPassword(),User.getUserType());
		if (respUser	==null) {
			response=new ResponseEntity<User>(HttpStatus.UNPROCESSABLE_ENTITY); // 201 created 
			
		}
		else
		{
			response=new ResponseEntity<User>(respUser,HttpStatus.OK); //500 
		}
		return response;
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User User){
		
		System.out.println("Inside update user....");
		
		ResponseEntity<User> response=null;
		User respUser=userService.saveUser(User);
		if (respUser	==null) {
			response=new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			
		}
		else
		{
			response=new ResponseEntity<User>(respUser,HttpStatus.OK);
		}
		return response;
	}
	
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable String userId){
		
		ResponseEntity<Object> response=null;
		boolean isDeleted=userService.deleteUser(userId);
		
				if (isDeleted) {
			response=new ResponseEntity<Object>(HttpStatus.OK);
			
		}
		else
		{
			response=new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
}