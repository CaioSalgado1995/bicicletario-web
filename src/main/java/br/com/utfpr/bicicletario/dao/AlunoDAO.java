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
	
	public void inserir(Aluno aluno) {
		manager.persist(aluno);
	}
	
	public List<Aluno> listar() {
		return manager
				.createQuery("select a from Aluno a order by a.nome asc", Aluno.class)
				.getResultList();
	}
	
	public List<Aluno> listarAlunosPeloNome(String nome) {
		try {
			return manager
					.createQuery("select a from Aluno a where a.nome like :nome order by a.nome asc", Aluno.class)
					.setParameter("nome", "%" + nome + "%")
					.getResultList();
		} catch (NoResultException nre) {
			return new ArrayList<Aluno>();
		}
	}
	
	public List<Aluno> buscarAlunoPelaMatricula(String registro) {
		try {
			return manager
					.createQuery("select a from Aluno a where a.registro = :registro", Aluno.class)
					.setParameter("registro", registro)
					.getResultList();
		} catch(NoResultException nre) {
			return new ArrayList<Aluno>();
		}
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
	
	public List<Aluno> listarAlunosComRegistroEntrada(List<String> listaRegistrosAlunos){
		return manager
				.createQuery("select a from Aluno a where a.registro in (?1)", Aluno.class)
				.setParameter(1, listaRegistrosAlunos)
				.getResultList();
	}
}
