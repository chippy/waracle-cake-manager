package com.waracle.cakemanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.waracle.cakemanager.data.CakeRepository;
import com.waracle.cakemanager.entity.Cake;
import com.waracle.cakemanager.rest.CakeController;


@ExtendWith(MockitoExtension.class)
public class CakeControllerUnitTests {

	@Mock
	private CakeRepository cakeRepositoryMock;
	
	@InjectMocks
	private CakeController cakeController;
	
	@Test
	public void getAllCakesReturnsAllCakesFromRepository() {
		// Prepare
		var testCakes = new ArrayList<Cake>();
		var testCake1 = new Cake("Cake 1", "The first test cake", "www.testcake.com/image1");
		var testCake2 = new Cake("Cake 2", "The second test cake", "www.testcake.com/image2");
		testCakes.add(testCake1);
		testCakes.add(testCake2);
		
		when(cakeRepositoryMock.findAll())
			.thenReturn(testCakes);
		
		// Test
		var cakesFromController = cakeController.getAllCakes();
		
		// Check all cakes are returned
		assertEquals(testCakes.size(), cakesFromController.size(), "Incorrect number of cakes returned");
		
		// Check both cakes are correct
		var cakeFromController1 = cakesFromController.stream().filter(c -> c.getTitle() == "Cake 1").findFirst();
		assertTrue(cakeFromController1.isPresent(), "Cake 1 was not returned"); 
		assertTrue(cakeFromController1.get().getDescription().equals(testCake1.getDescription()), "Cake 1 description is incorrect");
		assertTrue(cakeFromController1.get().getImage().equals(testCake1.getImage()), "Cake 1 image is incorrect");
		
		var cakeFromController2 = cakesFromController.stream().filter(c -> c.getTitle() == "Cake 2").findFirst();
		assertTrue(cakeFromController2.isPresent(), "Cake 2 was not returned"); 
		assertTrue(cakeFromController2.get().getDescription().equals(testCake2.getDescription()), "Cake 2 description is incorrect");
		assertTrue(cakeFromController2.get().getImage().equals(testCake2.getImage()), "Cake 2 image is incorrect");
		
	}
}
