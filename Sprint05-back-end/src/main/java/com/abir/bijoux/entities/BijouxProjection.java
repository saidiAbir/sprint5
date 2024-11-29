package com.abir.bijoux.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomBijx", types = { Bijoux.class }) 

public interface BijouxProjection {
	public String getNomBijoux(); 


}
