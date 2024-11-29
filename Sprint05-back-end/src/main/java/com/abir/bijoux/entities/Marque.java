package com.abir.bijoux.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMar;
	private String nomMar;
	private Date  dateCrea;
	
	@OneToMany(mappedBy ="marque")

	@JsonIgnore

	private List<Bijoux> bijx;
	
	
	
	
	public List<Bijoux> getBijx() {
		return bijx;
	}
	public void setBijx(List<Bijoux> bijx) {
		this.bijx = bijx;
	}
	
	
	
	

}
