package br.com.utfpr.bicicletario.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Bicicleta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String registroAluno;
	
	@NotEmpty(message = "O campo n�o pode estar vazio")
	private String marca;
	
	@NotEmpty(message = "O campo n�o pode estar vazio")
	private String cor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	
}
