package br.unitins.CRUD_levraria.controller;

import java.util.List;

import br.unitins.CRUD_levraria.model.Livro;

public class estoqueController {
	Livro livro ;
	List<Livro> llisvros ;

	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public List<Livro> getLlisvros() {
		return llisvros;
	}
	public void setLlisvros(List<Livro> llisvros) {
		this.llisvros = llisvros;
	}
	

}
