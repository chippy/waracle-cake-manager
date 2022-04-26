package com.waracle.cakemanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.waracle.cakemanager.data.CakeRepository;
import com.waracle.cakemanager.data.DatabaseInitialiser;
import com.waracle.cakemanager.entity.Cake;
import com.waracle.cakemanager.rest.CakeController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CakemanagerApplicationTests {
	
	Logger logger = LoggerFactory.getLogger(DatabaseInitialiser.class);
	
	@Autowired
	private CakeRepository cakeRepository;
	
	@Autowired
	private CakeController cakeController;
	
	@LocalServerPort
	private Integer port;
	
	@Test
	void contextLoads() {
		assertNotNull(cakeRepository);
		assertNotNull(cakeController);
	}
	
	@Test
	void cakeRepositoryContainsAllCakesFromJson() {
		var allCakes = cakeRepository.findAll();
		assertEquals(allCakes.size(), 20);
	}
	
	@Test 
	void cakeRepositoryContainsInsertedCake() {
		var allCakes = cakeRepository.findAll();
		int currentSize = allCakes.size();
		
		Cake newCake = new Cake();
		newCake.setTitle("Test Cake");
		newCake.setDescription("A Test Cake");
		newCake.setImage("http://www.images.com/test-cake.jpg");
		
		cakeRepository.add(newCake);
		
		allCakes = cakeRepository.findAll();
		
		assertEquals(allCakes.size(), currentSize + 1);
	}
	
	@Test
	void insertedCakeHasCorrectProperties() {		
		Cake newCake = new Cake();
		newCake.setTitle("Test Cake");
		newCake.setDescription("A Test Cake");
		newCake.setImage("http://www.images.com/test-cake.jpg");
				
		cakeRepository.add(newCake);
		Cake cakeFromDatabase = cakeRepository.getById(newCake.getId());
		
		assertEquals(newCake.getTitle(), cakeFromDatabase.getTitle());
		assertEquals(newCake.getDescription(), cakeFromDatabase.getDescription());
		assertEquals(newCake.getImage(), cakeFromDatabase.getImage());
	}
	
	@Test
	void cakesControllerReturnsAllCakes() {
		var allCakesFromDatabase = cakeRepository.findAll();
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<List<Cake>> response = null;
		
		try {	
			response = restTemplate.exchange(buildUrl("/cakes"), HttpMethod.GET, null, new ParameterizedTypeReference<List<Cake>>(){});
		} catch (Exception exception) {
			logger.error("Error: " + exception);
			fail();
		}
		
		List<Cake> cakesFromApi = response.getBody();
				
		assertEquals(allCakesFromDatabase.size(), cakesFromApi.size());
		assertTrue(cakesFromApi.containsAll(allCakesFromDatabase));
	}
	
	@Test
	void postToCakeControllerInsertsCake() {
		CakePostModel newCake = new CakePostModel();
		newCake.setTitle("Test Cake");
		newCake.setDescription("A Test Cake");
		newCake.setImage("http://www.images.com/test-cake.jpg");
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<Cake> response = null;
		HttpEntity<CakePostModel> cakeEntity = new HttpEntity<>(newCake);
		
		try {	
			response = restTemplate.exchange(buildUrl("/cakes"), HttpMethod.POST, cakeEntity, new ParameterizedTypeReference<Cake>(){});
		} catch (Exception exception) {
			logger.error("Error: " + exception);
			fail();
		}
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		
		Cake cake = response.getBody();
		
		int newCakeId = cake.getId();
		Cake cakeFromDatabase = cakeRepository.getById(newCakeId);
		assertEquals(newCake.getTitle(), cakeFromDatabase.getTitle());
		assertEquals(newCake.getDescription(), cakeFromDatabase.getDescription());
		assertEquals(newCake.getImage(), cakeFromDatabase.getImage());
	}
		
	private String buildUrl(String resource) {
		return "http://localhost:" + port + resource; 
	}
}
