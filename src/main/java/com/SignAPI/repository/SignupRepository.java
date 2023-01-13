package com.SignAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.SignAPI.model.Signup;

public interface SignupRepository extends MongoRepository<Signup, String> {

	List<Signup> findByEmail(String email);
	

	@Query("{password: ?0 }")
	List<Signup> getSignupByPassword(String password);


	
	

}
