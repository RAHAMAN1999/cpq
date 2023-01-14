package com.SignAPI.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
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
		try {
			String encPwd=Base64.getEncoder().encodeToString(signup.getPassword().getBytes("UTF-8"));
			signup.setPassword(encPwd);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return repository.save(signup);
	}
	
	public List<Signup> findAllSignup(){
		List<Signup> signups= repository.findAll();
		signups.stream().forEach(si->si.setPassword(getDecodedString(si.getPassword())));
		return signups;
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

	
	public String getDecodedString(String encodedValue) {
		try {
			return new String(Base64.getDecoder().decode(encodedValue.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
}
