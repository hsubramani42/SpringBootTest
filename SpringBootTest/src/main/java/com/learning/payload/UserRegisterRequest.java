package com.learning.payload;

import java.util.Set;

import lombok.Data;

@Data
//constraints are not set because in food update 
//user may send null value for the fields which he don't want to update 

public class UserRegisterRequest {
	private String email;

	private String name;

	private String password;

	private String address;

	private Set<String> roles;
}
