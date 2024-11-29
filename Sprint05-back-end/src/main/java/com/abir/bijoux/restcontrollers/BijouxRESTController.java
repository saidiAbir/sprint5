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
import com.abir.bijoux.service.BijouxService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BijouxRESTController {
	@Autowired
	BijouxService bijouxService;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	List<Bijoux> getAllBijoux() {
		return bijouxService.getAllBijoux();
	}

	@RequestMapping(path="/updatebijx", method = RequestMethod.PUT)
	public Bijoux updateBijoux(@RequestBody Bijoux bijoux) {
		return bijouxService.updateBijoux(bijoux);
	}

	@RequestMapping(value="/delbijx/{id}", method = RequestMethod.DELETE)
	public void deleteBijoux(@PathVariable("id") Long id) {
		bijouxService.deleteBijouxById(id);
	}

	@RequestMapping(value = "/bijxMar/{idMar}", method = RequestMethod.GET)
	public List<Bijoux> getBijouxByMarId(@PathVariable("idMar") Long idMar) {
		return bijouxService.findByMarqueIdMar(idMar);
	}

	@RequestMapping( path="/addbijx" ,method = RequestMethod.POST)
	public Bijoux createBijoux(@RequestBody Bijoux bijoux) {
		return bijouxService.saveBijoux(bijoux);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Bijoux getJeuxById(@PathVariable("id") Long id) {
		return bijouxService.getBijoux(id);
	}

	@RequestMapping(value = "/bijxByName/{nom}", method = RequestMethod.GET)
	public List<Bijoux> findByNomBijouxContains(@PathVariable("nom") String nom) {
		return bijouxService.findByNomBijouxContains(nom);
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Bijoux getBijouxById(@PathVariable("id") Long id) {
		return bijouxService.getBijoux(id);
	}
}
