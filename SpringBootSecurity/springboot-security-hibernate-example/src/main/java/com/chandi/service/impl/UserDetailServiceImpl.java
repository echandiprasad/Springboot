package com.chandi.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chandi.dao.UserDao;
import com.chandi.service.UserService;

@Service(value = "userDetailService")
public class UserDetailServiceImpl implements UserDetailsService, UserService{
	
	@Autowired
	private UserDao userDao;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.chandi.model.UserDetails user = userDao.findUserByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public List<com.chandi.model.UserDetails> getUsers() {
		return userDao.getUserDetails();
	}

}
