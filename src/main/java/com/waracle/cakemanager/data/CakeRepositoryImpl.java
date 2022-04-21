package com.waracle.cakemanager.data;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.waracle.cakemanager.entity.Cake;

@Repository
public class CakeRepositoryImpl implements CakeRepository {
	
	private EntityManager entityManager;
	
	@Autowired
	public CakeRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Cake> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		Query<Cake> query = session.createQuery("FROM Cake", Cake.class);
		List<Cake> cakes = query.getResultList();
		
		return cakes;
	}

	@Override
	@Transactional
	public Cake add(Cake cake) {
		
		Session session = entityManager.unwrap(Session.class);
		session.persist(cake);
		
		return cake;
	}

	@Override
	@Transactional
	public Cake getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<Cake> query = session.createQuery("FROM Cake C WHERE C.id = :cakeId", Cake.class);
		
		query.setParameter("cakeId", id);
		Cake result = query.getSingleResult();
		
		return result;
	}
}
