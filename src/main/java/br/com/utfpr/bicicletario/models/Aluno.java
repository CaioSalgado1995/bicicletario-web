package br.com.utfpr.bicicletario.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Aluno {

	@Id
	@NotEmpty(message = "O campo não pode ser vazio")
	@Size(min = 7, max = 7, message = "O campo deve conter 7 números")
	private String registro;
	
	@NotEmpty(message = "O campo não pode ser vazio")
	private String nome;

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
