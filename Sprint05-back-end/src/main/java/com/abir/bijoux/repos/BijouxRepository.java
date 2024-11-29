package com.abir.bijoux.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.entities.Marque;

@RepositoryRestResource(path = "rest") 

public interface BijouxRepository extends JpaRepository<Bijoux, Long> {
	
	
	 List<Bijoux> findByNomBijoux(String nom);
	 List<Bijoux> findByNomBijouxContains(String nom);
	/* @Query("select b from Bijoux b where b.nomBijoux like %?1 and b.prix > ?2")
	 List<Bijoux> findByNomPrix (String nom, Double prix);*/
	 @Query("select b from Bijoux b where b.nomBijoux like %:nom and b.prix > :prix")
	 List<Bijoux> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 
	 
	 @Query("select b from Bijoux b where b.marque = ?1") 
	 List<Bijoux> findByMarque (Marque marque); 
	 
	 
	 
	 List<Bijoux> findByMarqueIdMar(Long id); 
	 List<Bijoux> findByOrderByNomBijouxAsc();
	 
	
	/* @Query("select b from Bijoux b order by b.nomBijoux ASC, b.prixBijoux ASC")
	 List<Bijoux> trierBijouxNomsPrix();*/





}
