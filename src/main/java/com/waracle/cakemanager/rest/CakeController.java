package com.waracle.cakemanager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waracle.cakemanager.data.CakeRepository;
import com.waracle.cakemanager.entity.Cake;

@RestController
public class CakeController {
	
	private final CakeRepository cakeRepository;
	
	@Autowired
	public CakeController(CakeRepository cakeRepository) {
		this.cakeRepository = cakeRepository;
	}
	
	@GetMapping("/cakes")
	public List<Cake> getAllCakes() {
		return cakeRepository.findAll();
	}
}
