package br.com.utfpr.bicicletario.models;

public class Pesquisa {
	
	private String nome;
	
	private boolean registrarEntrada;
	
	private boolean registrarSaida;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isRegistrarEntrada() {
		return registrarEntrada;
	}

	public void setRegistrarEntrada(boolean registrarEntrada) {
		this.registrarEntrada = registrarEntrada;
	}

	public boolean isRegistrarSaida() {
		return registrarSaida;
	}

	public void setRegistrarSaida(boolean registrarSaida) {
		this.registrarSaida = registrarSaida;
	}
	
	
}
