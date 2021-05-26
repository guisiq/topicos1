package br.unitins.CRUD_levraria.controller;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.unitins.CRUD_levraria.model.Produto;


@Named
@RequestScoped
public class LoginController {
	Produto usuario;
	
	public String entrar() {
		
		if(Produto.listaUsuarios.contains(usuario)) {			
			return "menu.xhtml?faces-redirect=true";
		}
		return null;
		
		
	}
	public Produto getUsuario() {
		if (usuario == null) {
			usuario = new Produto();
		}
		return usuario;
	}

	public void setUsuario(Produto usuario) {
		this.usuario = usuario;
	}
}
