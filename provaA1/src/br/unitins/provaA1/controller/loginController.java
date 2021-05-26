package br.unitins.provaA1.controller;

import br.unitins.provaA1.model.Funcionario;
import br.unitins.provaA1.model.Perfil;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named
@RequestScoped
public class loginController {
	Funcionario funcionario;

	public String entrar() {
		
		if(Funcionario.getListaUsuarios().contains(funcionario)) {	
			int i = Funcionario.getListaUsuarios().indexOf(funcionario);
			Funcionario f = Funcionario.getListaUsuarios().get(i);
			if (f.getPerfil() == Perfil.ADM) {
				return "menu.xhtml?faces-redirect=true";				
			} else {
				return "sistemaemconstrucao.xhtml?faces-redirect=true";				
			}
		}
		
		FacesContext.getCurrentInstance().
		addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario ou senha incoreto ", null));
		
		System.out.println("ta errado");
		return null;
		
		
	}
	
	public Funcionario getFuncionario() {
		if (funcionario == null) {
			funcionario = new Funcionario();
			funcionario.setAtivo(true);
		}
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
