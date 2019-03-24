package br.com.utfpr.bicicletario.dao;

import java.util.ArrayList;
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
	
	public Aluno buscar(String registroAluno) {
		return manager.find(Aluno.class, registroAluno);
	}
	
	public void inserir(Aluno aluno) {
		manager.persist(aluno);
	}
	
	public void atualizar(Aluno aluno) {
		manager.merge(aluno);
	}
	
	public boolean existir(Aluno aluno) {
		return manager.contains(aluno);
	}

	public void deletar(Aluno aluno) {
		manager.remove(aluno);
	}
	
	public List<Aluno> buscar(int status) {
		return manager
				.createQuery("select a from Aluno a join fetch a.registro r where r.status = :status", Aluno.class)
				.setParameter("status", status)
				.getResultList();
	}
	
	public List<Aluno> buscar(String texto, int status) {
		try {
			return manager
					.createQuery("select a from Aluno a join fetch a.registro r where r.status = :status and (a.registroAluno = :matricula or a.nome like :nome )", Aluno.class)
					.setParameter("matricula", texto)
					.setParameter("nome", "%" + texto + "%")
					.setParameter("status", status)
					.getResultList();
		} catch(NoResultException nre) {
			return new ArrayList<Aluno>();
		}
	}
}