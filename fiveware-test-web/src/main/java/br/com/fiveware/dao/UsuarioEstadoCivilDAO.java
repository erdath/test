package br.com.fiveware.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.fiveware.model.UsuarioEstadoCivil;

public class UsuarioEstadoCivilDAO {
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<UsuarioEstadoCivil> getUsuariosEstadoCivils(){
		Query query = getEntityManager().createQuery("select uec from UsuarioEstadoCivil uec");
		List<UsuarioEstadoCivil> estados = (List<UsuarioEstadoCivil>)query.getResultList();
		getEntityManager().close();
		return estados;
	}
	
	public UsuarioEstadoCivil getUsuariosEstadoCivil(int id){
		Query query = getEntityManager().createQuery("select uec from UsuarioEstadoCivil uec where uec.id = :id");
		query.setParameter("id", id);
		UsuarioEstadoCivil usuarioEstadoCivil = (UsuarioEstadoCivil) query.getSingleResult();
		getEntityManager().close();
		return usuarioEstadoCivil;
	}
	
	private EntityManager getEntityManager(){
		if(this.entityManager == null || !this.entityManager.isOpen()){
			entityManager = JPA.geEntityManager();
		}
		return entityManager;
	}
	
	@SuppressWarnings("unused")
	private EntityTransaction getEntityTransaction(){
		return getEntityManager().getTransaction();
	}
}
