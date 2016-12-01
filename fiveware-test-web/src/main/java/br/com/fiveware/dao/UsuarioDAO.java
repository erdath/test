package br.com.fiveware.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.fiveware.model.Usuario;

public class UsuarioDAO {
	private EntityManager entityManager;
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserir(Usuario usuario){
		try{
			getEntityTransaction().begin();
			getEntityManager().persist(usuario);
			getEntityManager().flush();
			getEntityTransaction().commit();
			getEntityManager().close();
		}catch (Exception e) {
			if(getEntityTransaction().isActive())
				getEntityTransaction().rollback();
		}
	}
	
	private EntityManager getEntityManager(){
		if(this.entityManager == null || !this.entityManager.isOpen()){
			entityManager = JPA.geEntityManager();
		}
		return entityManager;
	}
	
	private EntityTransaction getEntityTransaction(){
		return getEntityManager().getTransaction();
	}
	
}
