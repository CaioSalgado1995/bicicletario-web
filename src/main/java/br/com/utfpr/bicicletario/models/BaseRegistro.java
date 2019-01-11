package br.com.utfpr.bicicletario.models;

import java.util.Calendar;

import org.hibernate.validator.constraints.NotEmpty;

public class BaseRegistro {

	private Calendar data;
	
	@NotEmpty(message = "O campo não pode ser vazio")
	private String horario;
	
	private String registroAluno;

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
	}
}
