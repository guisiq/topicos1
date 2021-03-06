package br.unitins.CRUD_escola.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.CRUD_escola.model.Aluno;
import br.unitins.CRUD_escola.model.Curso;



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
	
	public List<Aluno> getListaAluno() {
		if(listaAluno == null) {
			listaAluno = new ArrayList<Aluno>();
		}
		return listaAluno;
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
