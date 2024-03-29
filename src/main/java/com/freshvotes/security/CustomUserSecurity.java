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
		
		return super.getUsername();
	}

	@Override
	public String getPassword() {
		
		return super.getPassword();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}

	@Override
	public boolean isEnabled() {
	
		return true;
	}

}
