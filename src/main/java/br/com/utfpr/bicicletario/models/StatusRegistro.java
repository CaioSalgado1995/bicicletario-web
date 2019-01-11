package br.com.utfpr.bicicletario.models;

public enum StatusRegistro {

	ATIVO(1),   // ainda não registrou saída
	FECHADO(2); // ja registrou saída
	
	private int codigoStatus;
	
	private StatusRegistro(int codigoStatus) {
		this.codigoStatus = codigoStatus;
	}
	
	public int getCodigoStatus() {
		return codigoStatus;
	}
}
