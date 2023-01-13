package com.SignAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="signup")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signup {
	@Id
	private String signId;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String companyname;
}
