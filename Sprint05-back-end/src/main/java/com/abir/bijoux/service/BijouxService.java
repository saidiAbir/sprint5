package com.abir.bijoux.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.entities.Marque;

public interface BijouxService {
	  Bijoux saveBijoux(Bijoux b); 
	  Bijoux updateBijoux(Bijoux b); 
	  void deleteBijoux(Bijoux b); 
	  void deleteBijouxById(Long id); 
	  Bijoux getBijoux(Long id); 
	  List<Bijoux> getAllBijoux() ; 
	  Page<Bijoux> getAllBijouxParPage(int page, int size);
	  
	  List<Bijoux> findByNomBijoux(String nom); 
	  List<Bijoux> findByNomBijouxContains(String nom); 
	  List<Bijoux> findByNomPrix (String nom, Double prix); 
	  List<Bijoux> findByMarque (Marque marque); 
	  List<Bijoux> findByMarqueIdMar(Long id); 
	  List<Bijoux> findByOrderByNomBijouxAsc(); 
	/*  List<Bijoux> trierBijouxNomsPrix(); */


}
