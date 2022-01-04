package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.freshvotes.domain.User;
import com.freshvotes.repository.UserRepo;
import com.freshvotes.security.CustomUserSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 User user = userRepo.findByUsername(username);
		
		 if(user == null) 
		 {
			 throw new UsernameNotFoundException("Username and Password did not match");  
		 }
		 
		return new CustomUserSecurity(user);
	}
  
}
