package br.com.utfpr.bicicletario.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Aluno {

	@Id
	@NotEmpty(message = "O campo n�o pode ser vazio")
	@Size(min = 7, max = 7, message = "O campo deve conter 7 n�meros")
	private String registroAluno;
	
	@NotEmpty(message = "O campo n�o pode ser vazio")
	private String nome;

	@OneToMany(mappedBy = "aluno")
	private List<Registro> registro;
	
	public String getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Registro> getRegistro() {
		return registro;
	}

	public void setRegistro(List<Registro> registro) {
		this.registro = registro;
	}	
}
