package br.unitins.provaA1.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.provaA1.model.Aluno;
import br.unitins.provaA1.model.Curso;
import br.unitins.provaA1.model.Situacao;

@Named
@ViewScoped
public class AlunosController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8363072010842556702L;
	private Aluno aluno ;
	private List<Aluno> listaAluno;
	private Integer cont = 0 ;
	private String nome;
	
	public String getNome() {
		if (nome == null) {
			nome ="";
		}
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Aluno> getListaAluno() {
		if(listaAluno == null) {
			listaAluno = Aluno.getListaUsuarios();
			cont = listaAluno.size();
		}
		
		if(nome != "" ) {
			List<Aluno> listA;
			List<Aluno> listB = new ArrayList<Aluno>() ;
			listA = Aluno.getListaUsuarios();
			for(int i =0; i < listA.size() ;i++) {
				if(listA.get(i).getNome().equals(nome) ) {
					listB.add(listA.get(i));
				}
			}
			System.out.println("enviando lista de busca");
			System.out.println(nome);
			System.out.println(listB);
			return listB;
		}
		System.out.println(nome);
		System.out.println("enviando lista normal");
		return listaAluno;
	}
	public Situacao[] getListaSituacao() {
		return Situacao.values();
	}
	public Curso[] getListaCurso() {
		return Curso.values();
	}
	
	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}

	public Aluno getAluno() {
		if(aluno == null) {
			aluno = new Aluno();
		}
		return aluno;
	}

	public void setAluno(Aluno aluno) {

		this.aluno = aluno;
	}
	
	public void incluir() {
		System.out.println(aluno);		
		getAluno().setId(++cont);
		listaAluno.add(getAluno());
		System.out.println("Incluir");
		System.out.println(aluno);		
		limpar();
		
	}
	public void excluir(Aluno obj) {
		listaAluno.remove(obj);
		this.limpar();
	}

	public void alterar() {
		int index = listaAluno.indexOf(aluno);
		listaAluno.set(index, getAluno());
		System.out.println("alterar");
		System.out.println(index);		
		System.out.println(aluno);		
		System.out.println("------------");		
		System.out.println(listaAluno);		
		limpar();
	}
	
	public void alterar(Aluno obj) {
		System.out.println("limpar");
		System.out.println(obj);
		setAluno(obj);
	}
	
	public void limpar() {
		System.out.println("limpar");
		System.out.println("");
		aluno = null;
	}
	
	
	public void enviar() {
		System.out.println(aluno.getNome());
		System.out.println(aluno.getEmail());
		System.out.println(aluno.getSemestre());
		System.out.println(aluno.getPeriodo());
		System.out.println(aluno.getTelefone());
	}

}
