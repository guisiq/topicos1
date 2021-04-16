package br.unitins.CRUD_levraria.model;

import java.util.Date;

public class Livro {
	
	private String nome;
	private String autor ;
	protected enum Genero{
		AVENTURA,
		TERRO,
		COMEDIA,
		ROMANCE,
		SSUSPENCE,
		DIDATICO,
		
	}
	
	private Genero genero;
	private String editora ;
	private Date dataPublicacao;
	
	public Livro(String nome, String autor, Genero genero, String editora, Date dataPublicacao) {
		
		super();
		this.nome = nome;
		this.autor = autor;
		this.genero = genero;
		this.editora = editora;
		this.dataPublicacao = dataPublicacao;
	
	}
	
	public Livro() {
		super();
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
