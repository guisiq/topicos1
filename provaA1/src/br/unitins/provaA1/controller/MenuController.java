package br.unitins.provaA1.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MenuController {
	
	public String irAlunos() {
		return "alunos.xhtml?faces-redirect=true";
	}
	public String irLogin() {
		return "login.xhtml?faces-redirect=true";
	}
	

}
