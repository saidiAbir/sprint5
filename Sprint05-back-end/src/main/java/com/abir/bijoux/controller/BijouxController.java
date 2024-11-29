package com.abir.bijoux.controller;
import java.text.ParseException; 

import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.ModelMap; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.service.BijouxService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BijouxController {
	
	
	@Autowired 
	 BijouxService bijouxService; 
	 
	   @RequestMapping("/ListeBijoux") 
	 public String listeBijoux(ModelMap modelMap ,@RequestParam (name="page",defaultValue = "0") int page,  @RequestParam (name="size", defaultValue = "2") int size) 
	 { 
		 Page<Bijoux> bijx = bijouxService.getAllBijouxParPage(page, size); 
		 modelMap.addAttribute("bijoux", bijx); 
		 modelMap.addAttribute("pages", new int[bijx.getTotalPages()]);  
		 modelMap.addAttribute("currentPage", page);    
		 modelMap.addAttribute("size", size);    

		 return "listeBijoux"; 
	 } 
	 
	   @RequestMapping("/showCreate") 
	 public String showCreate() 
	 { 
	  return "createBijoux"; 
	 } 
	  
	 @RequestMapping("/saveBijoux") 
	 public String saveBijoux(@ModelAttribute("Bijoux") Bijoux bijoux,  
	     @RequestParam("date") String date, 
	     ModelMap modelMap) throws ParseException  
	 { 
	  //conversion de la date  
	       SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); 
	        Date dateCreation = dateformat.parse(String.valueOf(date)); 
	        bijoux.setDateCreation(dateCreation); 
	       
	  Bijoux saveBijoux = bijouxService.saveBijoux(bijoux); 
	 String msg ="bijoux enregistré avec Id "+saveBijoux.getIdBijoux(); 
	  modelMap.addAttribute("msg", msg); 
	  return "createBijoux"; 
	 } 
	 
	 
	    
	   @RequestMapping("/supprimerBijoux") 
	 public String supprimerBijoux(@RequestParam("id") Long id,  ModelMap modelMap,
	                                  @RequestParam (name="page",defaultValue = "0") int page, 
	                                  @RequestParam (name="size", defaultValue = "2") int size) 
 
	 {    
	  bijouxService.deleteBijouxById(id); 
	  Page<Bijoux> bijx = bijouxService.getAllBijouxParPage(page,size); 
	  modelMap.addAttribute("bijoux", bijx);   
	  modelMap.addAttribute("pages", new int[bijx.getTotalPages()]);  
	  modelMap.addAttribute("currentPage", page);  
	  modelMap.addAttribute("size", size); 
	  return "listeBijoux";  
	 } 
	    
	   @RequestMapping("/modifierBijoux") 
	 public String editerBijoux(@RequestParam("id") Long id, 
	                               ModelMap modelMap) 
	 { 
	  Bijoux b=  bijouxService.getBijoux(id); 
	  modelMap.addAttribute("bijoux", b);  
	  return "editerBijoux";  
	 } 
	 
	 @RequestMapping("/updateBijoux") 
	 public String updateBijoux(@ModelAttribute("bijoux") Bijoux bijoux,  @RequestParam("date") String date,  ModelMap modelMap) throws ParseException  
	 {   
	  //conversion de la date  
	      SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); 
	      Date dateCreation = dateformat.parse(String.valueOf(date)); 
	        bijoux.setDateCreation(dateCreation); 
	         
	    bijouxService.updateBijoux(bijoux); 
	    List<Bijoux> bijx = bijouxService.getAllBijoux(); 
	    modelMap.addAttribute("bijoux", bijx);  
	   return "listeBijoux"; 
	 } 
}