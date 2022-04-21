package com.waracle.cakemanager.data;

import java.util.List;

import com.waracle.cakemanager.entity.Cake;

public interface CakeRepository {
	
	public List<Cake> findAll();
	
	public Cake add(Cake cake);
	
	public Cake getById(int id);
}
