package br.unitins.CRUD_levraria.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Produto {
	
	private String email;
	private String senha;
	
	
	public static List<Produto> listaUsuarios = new ArrayList<Produto>(Arrays.asList(new Produto[]{
	}));
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
