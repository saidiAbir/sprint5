package com.abir.bijoux;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.abir.bijoux.entities.Bijoux;
import com.abir.bijoux.entities.Marque;
import com.abir.bijoux.service.BijouxService;

@SpringBootApplication
@EnableEurekaClient

public class BijouxApplication implements CommandLineRunner {
	@Autowired
	BijouxService bijouxService ;
	@Autowired

	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(BijouxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//bijouxService.saveBijoux(new Bijoux("bracelet",20.000 ,new Date()));
		//bijouxService.saveBijoux(new Bijoux("collier",50.000 ,new Date()));
		//bijouxService.saveBijoux(new Bijoux("bague",40.000 ,new Date()));
		repositoryRestConfiguration.exposeIdsFor(Bijoux.class,Marque.class);

		
	}

}
