package com.abir.bijoux;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.entities.Marque;
import com.abir.bijoux.repos.BijouxRepository;
import com.abir.bijoux.service.BijouxService;

@SpringBootTest
class BijouxApplicationTests  {
	
	@Autowired 
	private RepositoryRestConfiguration repositoryRestConfiguration; 



	@Autowired
	private BijouxRepository bijouxRepository;
	
	@Autowired
	private BijouxService bijouxService;
	@Test
	public void testCreateBijoux() {
	Bijoux bij = new Bijoux("boucle d'or",22.500,new Date());
	bijouxRepository.save(bij);
}
	@Test
	public void testFindBijoux()
	{
	Bijoux b = bijouxRepository.findById(1L).get(); 
	System.out.println(b);
	}
	@Test
	public void testUpdateBijoux()
	{
	Bijoux b = bijouxRepository.findById(1L).get();
	b.setPrix(30.0);
	bijouxRepository.save(b);
	}
	/*@Test
	public void testDeleteBijoux()
	{
	bijouxRepository.deleteById(1L);;
	}*/
	 
	@Test
	public void testListerTousBijouxs()
	{
	List<Bijoux> bijx = bijouxRepository.findAll();
	for (Bijoux b : bijx)
	{
	System.out.println(b);
	}
	}
	@Test 
	public void testFindByNomBijouxContains() 
	{ 
	Page<Bijoux>  bijx = bijouxService.getAllBijouxParPage(0,2); 
	System.out.println(bijx.getSize()); 
	System.out.println(bijx.getTotalElements()); 
	System.out.println(bijx.getTotalPages()); 
	
	bijx.getContent().forEach(b -> {System.out.println(b.toString()); 
	});  
	/*ou bien 
	for (Bijoux b : bijx) 
	{ 
	System.out.println(b); 
	} */ 
	}
	@Test
	public void testFindBijouxByNom()
	{
	List<Bijoux> bijx = bijouxRepository.findByNomBijoux("bracelet"); 
	for (Bijoux b : bijx)
	{
	System.out.println(b);
	}	}
	@Test
	public void testFindBijouxByNomContains()
	{
	List<Bijoux> bijx = bijouxRepository.findByNomBijoux("d'or"); 
	for (Bijoux b : bijx)
	{
	System.out.println(b);
	}	}
	@Test
	public void testfindByNomPrix()
	{
	List<Bijoux> bijx = bijouxRepository.findByNomPrix("bracelet", 20.000);
	for (Bijoux b : bijx)
	{
	System.out.println(b);
	}
	}
	@Test 
	public void testfindByMarque() 
	{ 
	Marque mar = new Marque(); 
	mar.setIdMar(1L);    
	List<Bijoux>  bijx = bijouxRepository.findByMarque(mar); 
	for (Bijoux b : bijx) 
	{ 
	System.out.println(b); 
	} 
	}
	@Test 
	public void findByMarqueIdMar() 
	{    
	List<Bijoux>  bijx = bijouxRepository.findByMarqueIdMar(1L); 
	for (Bijoux b : bijx) 
	{ 
	System.out.println(b); 
	} 
	} 
	
	@Test 
	 public void testfindByOrderByNomBijouxAsc() 
	  { 
	  List<Bijoux>  bijx =bijouxRepository.findByOrderByNomBijouxAsc();   
	   for (Bijoux b : bijx) 
	   		{ 
		   		System.out.println(b); 
	   		} 
	  } 
	/*@Test 
	 public void testTrierBijouxNomsPrix() 
	  { 
		  List<Bijoux>  bijx =bijouxRepository.trierBijouxNomsPrix();   
		   for (Bijoux b : bijx) 
		   		{ 
			   		System.out.println(b); 
		   		} 
	  } */
		
}