package br.com.fiveware.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getFactory(){
		if(entityManagerFactory == null || !entityManagerFactory.isOpen()){
			entityManagerFactory = Persistence.createEntityManagerFactory("fiveware-test-web");
		}
		return entityManagerFactory;
	}
	
	public static EntityManager geEntityManager(){
		return getFactory().createEntityManager();
	}
}
