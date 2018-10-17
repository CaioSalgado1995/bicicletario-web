package br.com.utfpr.bicicletario.models;

import javax.persistence.Entity;

@Entity
public class Bicicleta {

	private String registroAluno;
	
	private String marca;
	
	private String cor;

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
