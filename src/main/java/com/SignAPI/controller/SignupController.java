package com.SignAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SignAPI.model.Signup;
import com.SignAPI.service.SignupService;

@RestController
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	private SignupService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Signup createSignup(@RequestBody Signup signup) {
		return  service.addSignup(signup);
	}
	
	@GetMapping
	public List<Signup> getSignup(){
		return service.findAllSignup();
	}
	@GetMapping("/{signupId}")
	public Signup getSignup(@PathVariable String signupId) {
		return service.getSignupBySignupId(signupId);
	}
	
	@GetMapping("/email/{email}")
	public List<Signup> findSignupUsingEmail(@PathVariable String email){
		return service.getSignupByEmail(email);
		}
	
	@GetMapping("/password/{password}")
	public List<Signup> getSignupByPassword(@PathVariable String password){
		return service.getSignByPassword(password);
		
	}
	
	@PutMapping
	public Signup modifySignup(@RequestBody Signup signup) {
		return service.updateSignup(signup);
	}
	
	
	@DeleteMapping("/{SignupId}")
	public String deleteSignup(String signupId) {
		return service.deleteSingup(signupId);	
	}
	
	
	
}
