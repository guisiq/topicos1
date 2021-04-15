package br.unitins.CRUD_levraria.controller;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.unitins.CRUD_levraria.model.Usuario;


@Named
@RequestScoped
public class LoginController {
	Usuario usuario;
	
	public String entrar() {
		
		if(Usuario.listaUsuarios.contains(usuario)) {			
			return "estoque.xhtml?faces-redirect=true";
		}
		return null;
		
		
	}
	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
