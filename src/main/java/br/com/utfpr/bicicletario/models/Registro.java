package br.com.utfpr.bicicletario.models;

import java.util.Calendar;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Registro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar dataEntrada;
	
	private String horarioEntrada;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar dataSaida;
	
	private String horarioSaida;
	
	private int status;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Aluno.class)
	private Aluno aluno;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public Date getDataEntradaFormatada() {
		return dataEntrada.getTime();
	}

	public String getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}
	
	public Date getDataSaidaFormatada() {
		return dataSaida.getTime();
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}

