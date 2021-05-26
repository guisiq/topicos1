package br.unitins.provaA1.model;

public enum Situacao {
	Cursando(1),
	TRANCADO(2);
	
	private String label;
	private int key;
	
	public String getLabel() {
		return label;
	}

	public int getKey() {
		return key;
	}

	private Situacao(int key) {
		this.key = key;
		this.label = this.name().toLowerCase();
	} 

}
