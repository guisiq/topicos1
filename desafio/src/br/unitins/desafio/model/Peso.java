package br.unitins.desafio.model;

public class Peso {
	public enum TipoPeso{
		KG,
		GRAMA,
		LIBRA,
		MILIGRAMA;
		
	}
	private int id ;
	private double valor;
	private TipoPeso tipoPeso;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoPeso getTipoPeso() {
		return tipoPeso;
	}

	public void setTipoPeso(TipoPeso tipoPeso) {
		this.tipoPeso = tipoPeso;
	}

	public Peso() {
		// TODO Auto-generated constructor stub
	}

}
