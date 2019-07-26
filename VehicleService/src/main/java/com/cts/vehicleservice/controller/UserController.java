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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.vehicleservice.model.User;
import com.cts.vehicleservice.service.IUserService;

@RestController
@RequestMapping("/SpareParts")
@CrossOrigin
public class UserController {

	
	@Autowired
	private IUserService UserService;
	
	@GetMapping("/showAllParts")
	public ResponseEntity<List<SpareParts>> getAll() {
		
		System.out.println("In get all controller...");
		return new ResponseEntity<List<SpareParts>>(UserService.getAllParts(),HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/") public ModelAndView getHome() {
	 * 
	 * return new ModelAndView("home", "home","home"); }
	 */
	 
	@GetMapping("/{partId}")
	public ResponseEntity<SpareParts>getUser(@PathVariable String partId){
		ResponseEntity<SpareParts>  response=null;
		
		SpareParts SpareParts=UserService.getPart(partId);
		
		if(SpareParts!=null){
			response=new ResponseEntity<User>(SpareParts,HttpStatus.OK);
		}
		else {
			response=new ResponseEntity<SpareParts>(SpareParts,HttpStatus.NOT_FOUND);		
		}
		return response;
	}
	
	@PostMapping("/")
	public ResponseEntity<User> addPart(@RequestBody SpareParts SpareParts){
		
		System.out.println("Inside add user....");
		
		ResponseEntity<SpareParts> response=null;
		SpareParts respUser=UserService.saveUser(SpareParts);
		if (respUser	==null) {
			response=new ResponseEntity<SpareParts>(HttpStatus.OK);
			
		}
		else
		{
			response=new ResponseEntity<SpareParts>(respUser,HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping
	public ResponseEntity<SpareParts> updatePart(@RequestBody SpareParts SpareParts){
		
		System.out.println("Inside update user....");
		
		ResponseEntity<SpareParts> response=null;
		SpareParts respUser=UserService.saveUser(SpareParts);
		if (respUser	==null) {
			response=new ResponseEntity<SpareParts>(HttpStatus.BAD_REQUEST);
			
		}
		else
		{
			response=new ResponseEntity<SpareParts>(respUser,HttpStatus.OK);
		}
		return response;
	}
	
	
	@DeleteMapping("/deletePart/{partId}")
	public ResponseEntity<Void> deletePart(@PathVariable String partId){
		
		ResponseEntity<Void> response=null;
		boolean isDeleted=UserService.deletePart(partId);
		
				if (isDeleted) {
			response=new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		else
		{
			response=new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
}
