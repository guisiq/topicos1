package br.unitins.desafio.model;
import java.time.LocalDate;

public class Produto {
	private int id;
	private String nome ;
	private double preco;
	private String codigo;
	//parametros opicionais 
	private LocalDate dataVencimento;
	private LocalDate dataFabricacao;
	private int quantEstoque;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public int getQuantEstoque() {
		return quantEstoque;
	}

	public void setQuantEstoque(int quantEstoque) {
		this.quantEstoque = quantEstoque;
	}

	public Peso getPeso() {
		return peso;
	}

	public void setPeso(Peso peso) {
		this.peso = peso;
	}

	private Peso peso;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

}
