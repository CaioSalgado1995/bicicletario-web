package br.com.utfpr.bicicletario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.utfpr.bicicletario.models.Aluno;

@Repository
@Transactional
public class AlunoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Aluno aluno) {
		manager.persist(aluno);
	}
	
	public List<Aluno> listar() {
		return manager.createQuery("select a from Aluno a", Aluno.class)
				.getResultList();
	}
	
	public boolean existe(Aluno aluno) {
		try {
			manager
				.createQuery("select a from Aluno a where a.registro = :registro", Aluno.class)
				.setParameter("registro", aluno.getRegistro())
				.getSingleResult();
		} catch (NoResultException nre) {
			return false;
		}
		return true;
	}
}
