package com.chandi.dao;

import java.util.List;

import com.chandi.model.UserDetails;

public interface UserDao {
	
	List<UserDetails> getUserDetails();
	UserDetails findUserByEmail(String email);

}
