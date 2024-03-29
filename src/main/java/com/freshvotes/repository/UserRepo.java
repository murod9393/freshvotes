package com.freshvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.freshvotes.domain.User;

@Repository
@Component
public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);

	
	
}
