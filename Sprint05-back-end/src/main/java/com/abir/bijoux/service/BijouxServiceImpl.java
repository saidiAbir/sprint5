package com.abir.bijoux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.entities.Marque;
import com.abir.bijoux.repos.BijouxRepository;
import com.abir.bijoux.repos.ImageRepository;
@Service
public class BijouxServiceImpl implements BijouxService{
	@Autowired
	BijouxRepository bijouxRepository;
	@Autowired
	ImageRepository imageRepository;

	@Override
	public Bijoux saveBijoux(Bijoux b) {
		// TODO Auto-generated method stub
		return bijouxRepository.save(b);
	}

	/*@Override
	public Bijoux updateBijoux(Bijoux b) {
		// TODO Auto-generated method stub
		return bijouxRepository.save(b);
	}*/

	@Override
	public void deleteBijoux(Bijoux b) {
		bijouxRepository.delete(b);		
	}
	
	@Override 
	 public Bijoux updateBijoux(Bijoux b) { 
	  /*Long oldBijxImageId = 
	this.getBijoux(b.getIdBijoux()).getImage().getIdImage(); 
	  Long newBijxImageId = b.getImage().getIdImage(); */
	   
	  Bijoux prodUpdated = bijouxRepository.save(b); 
	   
	 /* if (oldBijxImageId != newBijxImageId) //si l'image a été modifiée 
	   imageRepository.deleteById(oldBijxImageId); */
	   
	  return prodUpdated; 
	 } 
	@Override
	public void deleteBijouxById(Long id) {
		bijouxRepository.deleteById(id);		
	}

	@Override
	public Bijoux getBijoux(Long id) {
		// TODO Auto-generated method stub
		return bijouxRepository.findById(id).get();
	}

	public List<Bijoux> getAllBijoux() {
		// TODO Auto-generated method stub
		return bijouxRepository.findAll();
	}

	@Override
	public Page<Bijoux> getAllBijouxParPage(int page, int size) {
		// TODO Auto-generated method stub
		return bijouxRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Bijoux> findByNomBijoux(String nom) {
		return bijouxRepository.findByNomBijoux(nom);
	}

	@Override
	public List<Bijoux> findByNomBijouxContains(String nom) {
		// TODO Auto-generated method stub
		return bijouxRepository.findByNomBijouxContains(nom);
	}

	@Override
	public List<Bijoux> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bijoux> findByMarque(Marque marque) {
		// TODO Auto-generated method stub
		return bijouxRepository.findByMarque(marque);
	}

	@Override
	public List<Bijoux> findByMarqueIdMar(Long id) {
		return bijouxRepository.findByMarqueIdMar(id);
	}

	@Override
	public List<Bijoux> findByOrderByNomBijouxAsc() {
		return bijouxRepository.findByOrderByNomBijouxAsc();
	}


	/*@Override
	public List<Bijoux> trierBijouxNomsPrix(){
		return bijouxRepository.trierBijouxNomsPrix();
	}*/

}
