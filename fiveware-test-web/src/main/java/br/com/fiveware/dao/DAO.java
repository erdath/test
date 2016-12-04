package br.com.fiveware.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DAO<T> {
	T buscar(int id);
	List<T> lista();
	void inserir(T t);
}
