package com.freshvotes.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.freshvotes.domain.Feature;


@Repository
@Component
public interface FeatureRepo extends JpaRepository<Feature, Long> {
	
}
