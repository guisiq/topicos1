package br.unitins.CRUD_escola.model;

public enum Curso {
	DIREITO("direito",0),
	SISTEMAS_DE_INFORMACAO("Sistemas de informacao",1),
	ASISTENCIA_SOCIAL("asistencia social",2),
	AGRONOMIA("agronomia",3);
	
	private String label;
	private int key;
	
	private Curso(String label, int key) {
		this.label = label;
		this.key = key;
	}
	
	public String getLabel() {
		return label;
	}
	
	public int getKey() {
		return key;
	}
	
}
