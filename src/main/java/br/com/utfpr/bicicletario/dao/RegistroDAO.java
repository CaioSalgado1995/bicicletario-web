package br.com.utfpr.bicicletario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.utfpr.bicicletario.models.Registro;
import br.com.utfpr.bicicletario.models.StatusRegistro;

@Repository
@Transactional
public class RegistroDAO {

	@PersistenceContext
	private EntityManager manager;
	
	private static final String STATUS = "status";
	
	public void inserir(Registro registroEntrada) {
		manager.persist(registroEntrada);
	}

	public boolean existeRegistroAtivo(Registro registroEntrada) {
		try {
			manager
			.createQuery("select r from Registro r where r.registroAluno = :registroAluno AND r.status = :status", 
					Registro.class)
			.setParameter("registroAluno", registroEntrada.getRegistroAluno())
			.setParameter(STATUS, StatusRegistro.ATIVO.getCodigoStatus())
			.getSingleResult();
			return true;
		} catch (NoResultException nre) {
			return false;
		}
	}

	public Registro buscaRegistro(String registroAluno, int codigoStatus) {
		return manager.createQuery("select r from Registro r where r.registroAluno = :registroAluno AND r.status = :status",
				Registro.class)
			.setParameter("registroAluno", registroAluno)
			.setParameter(STATUS, codigoStatus)
			.getSingleResult();
	}

	public void atualiza(Registro registroAtual) {
		manager
		.createQuery("update Registro r SET r.dataSaida = :dataSaida, r.horarioSaida = :horarioSaida, r.status = :status WHERE r.id = :id")
		.setParameter("dataSaida", registroAtual.getDataSaida())
		.setParameter("horarioSaida", registroAtual.getHorarioSaida())
		.setParameter(STATUS, registroAtual.getStatus())
		.setParameter("id", registroAtual.getId())
		.executeUpdate();
	}

	public List<Registro> listaRegistroPorStatus(int codigoStatus) {
		try {
			return manager
				.createQuery("select r from Registro r where r.status = :status", Registro.class)
				.setParameter(STATUS, codigoStatus)
				.getResultList();
		} catch (NoResultException nre) {
			return new ArrayList<Registro>();
		}
	}
}
