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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.vehicleservice.model.SpareParts;
import com.cts.vehicleservice.service.PartService;

@RestController
@RequestMapping("/SpareParts")
@CrossOrigin
public class PartController {

	@Autowired
	private PartService PartService;

	@GetMapping("/showAllparts")
	public ResponseEntity<List<SpareParts>> getAll() {

		System.out.println("In get all controller...");
		return new ResponseEntity<List<SpareParts>>(PartService.getAllparts(), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/") public ModelAndView getHome() {
	 * 
	 * return new ModelAndView("home", "home","home"); }
	 */

	@GetMapping("/{partId}")
	public ResponseEntity<SpareParts> getPart(@PathVariable Integer partId) {
		ResponseEntity<SpareParts> response = null;

		SpareParts spareparts = PartService.getPart(partId);

		if (spareparts != null) {
			response = new ResponseEntity<SpareParts>(spareparts, HttpStatus.OK);
		} else {
			response = new ResponseEntity<SpareParts>(spareparts, HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@PostMapping("/addPart")
	public ResponseEntity<SpareParts> addPart(@RequestBody SpareParts spareparts) {

		System.out.println("Inside add part....");

		ResponseEntity<SpareParts> response = null;
		SpareParts respUser = PartService.savePart(spareparts);
		if (respUser == null) {
			response = new ResponseEntity<SpareParts>(HttpStatus.OK);

		} else {
			response = new ResponseEntity<SpareParts>(respUser, HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping("/deletePart/{partId}") public ResponseEntity<Void>
	deletePart(@PathVariable Integer partId){
	  
	  ResponseEntity<Void> response=null; boolean
	  isDeleted=PartService.deletePart(partId);
	  
	  if (isDeleted) { response=new ResponseEntity<Void>(HttpStatus.OK);
	  
	  } else { response=new ResponseEntity<Void>(HttpStatus.NOT_FOUND); } 
	  return
	  response; }

	/*
	 * @PutMapping public ResponseEntity<User> updateUser(@RequestBody User User){
	 * 
	 * System.out.println("Inside update user....");
	 * 
	 * ResponseEntity<User> response=null; User respUser=UserService.saveUser(User);
	 * if (respUser ==null) { response=new
	 * ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	 * 
	 * } else { response=new ResponseEntity<User>(respUser,HttpStatus.OK); } return
	 * response; }
	 * 
	 * 
	 * @DeleteMapping("/deleteUser/{userId}") public ResponseEntity<Void>
	 * deleteUser(@PathVariable String userId){
	 * 
	 * ResponseEntity<Void> response=null; boolean
	 * isDeleted=UserService.deleteUser(userId);
	 * 
	 * if (isDeleted) { response=new ResponseEntity<Void>(HttpStatus.OK);
	 * 
	 * } else { response=new ResponseEntity<Void>(HttpStatus.NOT_FOUND); } return
	 * response; }
	 */

}
