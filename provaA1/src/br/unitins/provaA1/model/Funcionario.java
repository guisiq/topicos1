package br.unitins.provaA1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Funcionario {
	@NotEmpty(message ="o campo email nao pode estar vazio ")
	@Pattern(regexp ="([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})",message ="cpf invalido")
	/*
	Solução:
		Esta solução valida estes formatos: 00000000000, 00000000000000, 000.000.000-00, 00.000.000/0000-00 e até 000000000-00 ou 00000000/0000-00, por exemplo. Os pontos e traços são opcionais em cada uma das posições.

		O que não é aceito, por exemplo: 000-000-000-00 */
	private String cpf;
	private Integer id;
	@NotEmpty(message ="o campo senha nao pode estar vazio ")	
	@Size(min = 8, max = 14)
	private String senha;
	private boolean ativo;
	private Perfil perfil;
	private LocalDate dataCadastro;
	
	
	

	//carga de dados 
	public static List<Funcionario> listaUsuarios = new ArrayList<Funcionario>(Arrays.asList(new Funcionario[]{
			new Funcionario("029.948.412-08",1,"ADM12345",true,Perfil.ADM),
			new Funcionario("038.848.412-08",2,"ADM12345",true,Perfil.ADM),
			new Funcionario("047.748.412-08",3,"ADM12345",true,Perfil.ADM),
			new Funcionario("056.648.412-08",4,"ADM12345",true,Perfil.ADM),
			new Funcionario("065.748.412-08",5,"ADM12345",true,Perfil.ADM),
			new Funcionario("074.548.412-08",6,"ADM12345",true,Perfil.ADM),

			new Funcionario("074.548.413-08",6,"ADM12345",true,Perfil.ATENDENTE),
			new Funcionario("074.548.414-08",6,"ADM12345",true,Perfil.ATENDENTE),
	}));

	
	
	public Perfil getPerfil() {
		return perfil;
	}



	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Funcionario(String cpf, Integer id, String senha, boolean ativo,Perfil perfil) {
		super();
		this.cpf = cpf;
		this.id = id;
		this.senha = senha;
		this.ativo = ativo;
		this.perfil = perfil;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public boolean isAtivo() {
		return ativo;
	}



	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}



	public static List<Funcionario> getListaUsuarios() {
		return listaUsuarios;
	}



	public static void setListaUsuarios(List<Funcionario> listaUsuarios) {
		Funcionario.listaUsuarios = listaUsuarios;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (ativo != other.ativo)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
	
	
	
	
}
