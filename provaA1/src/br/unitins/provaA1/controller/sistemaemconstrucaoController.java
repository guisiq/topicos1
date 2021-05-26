package br.unitins.provaA1.controller;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class sistemaemconstrucaoController {
	public String irLogin() {
		return "login.xhtml?faces-redirect=true";
	}
}
