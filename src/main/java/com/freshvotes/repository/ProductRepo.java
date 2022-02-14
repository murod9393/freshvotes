package com.freshvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.freshvotes.domain.Product;

@Repository
@Component
public interface ProductRepo extends JpaRepository<Product, Long> {

}
