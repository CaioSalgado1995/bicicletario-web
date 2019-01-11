package br.com.utfpr.bicicletario.models;

public enum StatusRegistro {

	ATIVO(1),   // ainda n�o registrou sa�da
	FECHADO(2); // ja registrou sa�da
	
	private int codigoStatus;
	
	private StatusRegistro(int codigoStatus) {
		this.codigoStatus = codigoStatus;
	}
	
	public int getCodigoStatus() {
		return codigoStatus;
	}
}
