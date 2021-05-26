package br.unitins.provaA1.model;

public enum Perfil {
	ADM(1),
	ATENDENTE(2);
	private int id;
	private String label;
	Perfil(int id){
		this.id = id;
		this.label = this.name().toLowerCase();
	}

}
