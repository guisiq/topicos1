package br.unitins.provaA1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Aluno {
	private Integer id ;
	private String nome ;
	@Email(message = "Informe um email valido.")
	@NotEmpty(message ="o campo email nao pode estar vazio ")
	private String email;
	@Pattern(regexp ="[0-9]{4}[.][1-2]{1}")
	private String semestre ;
	private int periodo  ;
	@Pattern(regexp ="^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$" ,message = "informe um numero validodo n/ ex:(xx) xxxxx-xxxx " )
	@NotEmpty(message ="o campo telefone nao pode estar vazio ")
	private String telefone ;
	private Curso curso;
	private Situacao situacao;
	
	private static List<Aluno> listaUsuarios = new ArrayList<Aluno>(Arrays.asList(new Aluno[]{
			new Aluno(1,"Guilherme henrique","Guilhermehenrique@gmail.com","2020-1",2,"(63) 98138-9666",Curso.AGRONOMIA,Situacao.Cursando),
			new Aluno(2,"luiz nicolal","luiznicolal@gmail.com","2020-1",2,"(63) 98138-9666",Curso.ASISTENCIA_SOCIAL,Situacao.Cursando),
			new Aluno(3,"Luana mendes","Luanamendes@gmail.com","2020-1",2,"(63) 98138-9666",Curso.DIREITO,Situacao.Cursando),
			new Aluno(4,"Heitor da Silva","heitordasilva@gmail.com","2020-1",2,"(63) 98138-9666",Curso.SISTEMAS_DE_INFORMACAO,Situacao.Cursando),
			new Aluno(5,"Jo Soares","JoSoares@gmail.com","2020-2",2,"(63) 98138-9666",Curso.DIREITO,Situacao.TRANCADO),
			new Aluno(6,"Antoney Augusto","AntoneyAugusto@gmail.com","2019-2",2,"(63) 98138-9666",Curso.SISTEMAS_DE_INFORMACAO,Situacao.TRANCADO),
	}));
	
	
	//#region metodos get e seters 
	
	
	
	
	public Integer getId() {
		return id;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public static List<Aluno> getListaUsuarios() {
		return listaUsuarios;
	}

	public static void setListaUsuarios(List<Aluno> listaUsuarios) {
		Aluno.listaUsuarios = listaUsuarios;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluno(Integer id, String nome, @Email(message = "Informe um email valido.") String email, String semestre,
			int periodo, String telefone, Curso curso,Situacao situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.semestre = semestre;
		this.periodo = periodo;
		this.telefone = telefone;
		this.curso = curso;
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", semestre=" + semestre + ", periodo="
				+ periodo + ", telefone=" + telefone + "]";
	}
	
}
