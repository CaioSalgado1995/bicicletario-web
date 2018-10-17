package br.com.utfpr.bicicletario.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.utfpr.bicicletario.models.Bicicleta;

@Repository
@Transactional
public class BicicletaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Bicicleta bicicleta) {
		manager.persist(bicicleta);
	}
}
