package br.com.fiveware.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.com.fiveware.model.UsuarioEstadoCivil;

@Repository
public class UsuarioEstadoCivilDAO implements DAO<UsuarioEstadoCivil> {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioEstadoCivil> lista() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select uec from UsuarioEstadoCivil uec").getResultList();
	}

	@Override
	public UsuarioEstadoCivil buscar(int id) {
		// TODO Auto-generated method stub
		return (UsuarioEstadoCivil) entityManager
				.createQuery("select uec from UsuarioEstadoCivil uec where uec.id = :id").setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public void inserir(UsuarioEstadoCivil t) {
		// TODO Auto-generated method stub
		entityManager.persist(t);
	}

}
