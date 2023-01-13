package com.SignAPI.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SignAPI.model.Signup;
import com.SignAPI.repository.SignupRepository;

@Service
public class SignupService {
	
	@Autowired
	private SignupRepository repository;
	
	
	//create 
	public Signup addSignup(Signup signup) {
		signup.setSignId(UUID.randomUUID().toString());
		return repository.save(signup);
	}
	
	public List<Signup> findAllSignup(){
		return repository.findAll();
	}
	
	public Signup getSignupBySignupId(String signid) {
		return repository.findById(signid).get();
	}
	
	public List<Signup> getSignupByEmail(String email){
		
		return repository.findByEmail(email); 
	}
	
	public List<Signup> getSignByPassword(String password){
		return repository.getSignupByPassword(password);	
	}
	
	
	public  Signup updateSignup(Signup signupRequest) {
	Signup	existingsignup=repository.findById(signupRequest.getSignId()).get();
	existingsignup.setCompanyname(signupRequest.getCompanyname());
	existingsignup.setEmail(signupRequest.getEmail());
	existingsignup.setFirstname(signupRequest.getFirstname());
	existingsignup.setLastname(signupRequest.getLastname());
	existingsignup.setPassword(signupRequest.getPassword());
	return repository.save(existingsignup);
	}
	
	public String deleteSingup(String signupId) {
		repository.deleteById(signupId);
		return signupId+"signup deleted from the database";
	}

	
	
	
	
	
	
	
}
