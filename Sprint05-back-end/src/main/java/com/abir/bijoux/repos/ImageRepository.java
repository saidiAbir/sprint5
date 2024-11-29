package com.abir.bijoux.repos;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.abir.bijoux.entities.Image; 
 
 
public interface ImageRepository extends JpaRepository<Image , Long> { 
}
