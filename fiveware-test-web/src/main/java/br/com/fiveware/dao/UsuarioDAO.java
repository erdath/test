package br.com.fiveware.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.fiveware.model.Usuario;

@Repository
public class UsuarioDAO implements DAO<Usuario> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Usuario buscar(int id) {
		// TODO Auto-generated method stub
		return (Usuario) entityManager.createQuery("select u from Usuario u where u.id = :id").setParameter("id", id)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> lista() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select u from Usuario u").getResultList();
	}

	@Override
	public void inserir(Usuario t) {
		// TODO Auto-generated method stub
		entityManager.persist(t);
	}

}
