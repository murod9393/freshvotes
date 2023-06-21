package com.freshvotes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;

@Repository
@Component
public interface ProductRepo extends JpaRepository<Product, Long> {
	
	List<Product> findByUser(User user);
	
	Optional<Product> findByName(String name);

}
