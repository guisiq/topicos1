package br.unitins.topicos.Controller;

import  javax.enterprise.context.RequestScoped ;
import  javax.inject.Named ;

@Named
@RequestScoped
public class ReclamacaoController {
	private String nome = ":.[a-zA-Z]+";
	private String email = ":.[a-zA-Z]+";
	private String observacao = ":.[a-zA-Z]+";

	//#region metodos get e seters 
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	//#endregion
	public void enviar() {
		System.out.println(nome );
		System.out.println(email);
		System.out.println(observacao );
	}
}
