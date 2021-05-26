package br.unitins.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.desafio.model.Peso;
import br.unitins.desafio.model.Peso.TipoPeso;
import br.unitins.desafio.model.Produto;
import br.unitins.desafio.model.dao.DAO;
import br.unitins.desafio.model.dao.ProdutoDAO;

@Named
@ViewScoped
public class EstoqueController implements Serializable{
	
	private static final long serialVersionUID = 4122501711713532721L;
	private List<Produto> listaProdutos = null;
	private Produto produto = null;

	
	
	public TipoPeso[] getListPeso() {
		return Peso.TipoPeso.values();
	}
	
	public Produto getProduto() {
		if(this.produto == null) {
			Produto aux = new Produto();
			aux.setCodigo("teste 1");
			aux.setNome("teste 2");
			this.produto = new Produto();
		}
		return this.produto;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProdutos() {
		if (listaProdutos == null) {
			DAO<Produto> dao = new ProdutoDAO();
			listaProdutos = dao.obterTodos();
			if (listaProdutos == null)
				listaProdutos = new ArrayList<Produto>();
		}
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public void incluir() {
		DAO<Produto> dao = new ProdutoDAO();
		if (dao.inserir(getProduto())) {
			limpar();
		}
	}
	public void limpar() {
		this.produto = null;
		this.listaProdutos = null;
	}


}
