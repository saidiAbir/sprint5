package com.abir.bijoux.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.entities.Marque;
import com.abir.bijoux.repos.MarqueRepository;
import com.abir.bijoux.service.BijouxService;

@RestController 
@RequestMapping("/api/mar") 

@CrossOrigin("*") 
public class MarqueRESTController {
	@Autowired 
	 MarqueRepository marqueRepository;
	@Autowired
	
	 BijouxService bijouxService;

	  
	 @RequestMapping(method=RequestMethod.GET) 
	 public List<Marque> getAllMarque() 
	 { 
	  return marqueRepository.findAll(); 
	 } 
	  
	 @RequestMapping(value="/{id}",method = RequestMethod.GET) 
	 public Marque getMarqueById(@PathVariable("id") Long id) { 
	  return marqueRepository.findById(id).get(); 
	  }  
	 
	 @RequestMapping(value="/bijxByName/{nom}",method = RequestMethod.GET) 
	 public List<Bijoux> findByNomBijouxContains(@PathVariable("nom") String nom) { 
	return bijouxService.findByNomBijouxContains(nom); 
	 } 
	 @RequestMapping(method = RequestMethod.POST)
	 public  void ajoutMarque(@RequestBody Marque marque) {
	marqueRepository.save(marque);
	 }
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteMarque(@PathVariable("id") Long id) {
	    marqueRepository.deleteById(id);
	  }
	  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
	  public void updateMar(@RequestBody Marque marque) {
	    marqueRepository.save(marque);

	  }
	}


