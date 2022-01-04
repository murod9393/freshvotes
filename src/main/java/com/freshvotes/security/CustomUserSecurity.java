package com.freshvotes.security;


import java.util.Set;


import org.springframework.security.core.userdetails.UserDetails;

import com.freshvotes.domain.User;


public class CustomUserSecurity extends User implements UserDetails {

	private static final long serialVersionUID = 2671648417587281347L;
	
	public CustomUserSecurity() {}
	
	public CustomUserSecurity(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}


	@Override
	public Set<Authority> getAuthorities() {
		
		return super.getAuthorities();
	}
	
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
