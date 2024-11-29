package com.abir.bijoux.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Bijoux {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBijoux;
	private String nomBijoux;
	private Double prix;
	private Date dateCreation;

	@ManyToOne
	private Marque marque;
	
	
	

	@OneToMany(mappedBy = "bijoux")
	private List<Image> images;

	
	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Bijoux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bijoux(String nomBijoux, Double prix, Date dateCreation) {
		super();
		this.nomBijoux = nomBijoux;
		this.prix = prix;
		this.dateCreation = dateCreation;
	}

	public Long getIdBijoux() {
		return idBijoux;
	}

	public void setIdBijoux(Long idBijoux) {
		this.idBijoux = idBijoux;
	}

	public String getNomBijoux() {
		return nomBijoux;
	}

	public void setNomBijoux(String nomBijoux) {
		this.nomBijoux = nomBijoux;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Bijoux [idBijoux=" + idBijoux + ", nomBijoux=" + nomBijoux + ", prix=" + prix + ", dateCreation="
				+ dateCreation + "]";
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	

}
