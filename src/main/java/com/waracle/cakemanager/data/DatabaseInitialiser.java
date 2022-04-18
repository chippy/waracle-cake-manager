package com.waracle.cakemanager.data;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemanager.entity.Cake;

@Component
public class DatabaseInitialiser {

	Logger logger = LoggerFactory.getLogger(DatabaseInitialiser.class);
	
	private CakeRepository cakeRepository;
	
	@Autowired
	public DatabaseInitialiser(CakeRepository cakeRepository) {
		this.cakeRepository = cakeRepository;
	}
	
	@PostConstruct
	public void initialiseDatabase() {
		logger.info("Initialising database.");
		
		logger.info("Retrieving cake JSON");
		try (InputStream inputStream = new URL("https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json").openStream()) {
			
			logger.info("Deserializing cake JSON");
			ObjectMapper mapper = new ObjectMapper();
			List<Cake> cakes = mapper.readValue(inputStream, new TypeReference<List<Cake>>() {});
			cakes.forEach(cakeRepository::add);
			
			logger.info("Database now contains the following cakes: ");
			cakeRepository.findAll().forEach(c -> logger.info(c.toString()));
			
		} catch (Exception exception) {
			logger.error("An error was encountered while initialising the database.", exception);
		}
	}
}
