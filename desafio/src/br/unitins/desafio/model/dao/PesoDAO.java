package br.unitins.desafio.model.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unitins.desafio.model.Peso;
import br.unitins.desafio.model.Produto;

public class PesoDAO implements DAO<Peso>{
	private static List<Peso> listaPeso;

	public static List<Peso> getListaPeso() {
		return listaPeso;
	}

	public static void setListaPeso(List<Peso> listaPeso) {
		PesoDAO.listaPeso = listaPeso;
	}

	@Override
	public boolean inserir(Peso obj) {
		Connection conn = DAO.getConnection();
		boolean deuErro = false;
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO peso ");
		sql.append(" (valor,tipo) ");
		sql.append("VALUES ");
		sql.append(" (?, ?) ");
		
		StringBuffer sqlConsult = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  u.id, ");
		sql.append("FROM ");
		sql.append("  peso u ");
		sql.append(" ORDER BY id DESC");

		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setDouble(1, obj.getValor());
			stat.setInt(2, obj.getTipoPeso().ordinal());
			
			stat.execute();
			// atualizar o id do objeto 
			stat = conn.prepareStatement(sqlConsult.toString());
			ResultSet rs = stat.executeQuery();
			obj.setId(rs.getInt("id"));
	
		} catch (SQLException e) {
			e.printStackTrace();
			deuErro = true;
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (deuErro)
			return false;
		
		return true;
	}
	//nao tera aulteracao do obj ira apaga e criar outro
	@Override
	public boolean alterar(Peso obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Integer id) {
		Connection conn = DAO.getConnection();
		boolean deuErro = false;
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM peso WHERE id = ? ");
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setInt(1, id);
			
			stat.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			deuErro = true;
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (deuErro)
			return false;
		
		return true;
	}

	@Override
	public List<Peso> obterTodos() {
		
		Connection conn = DAO.getConnection();
		List<Peso> listaPeso = new ArrayList<Peso>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  u.id, ");
		sql.append("  u.valor, ");
		sql.append("  u.tipo_peso, ");
		sql.append("FROM ");
		sql.append("  peso u ");
		sql.append("ORDER BY u.id ");
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				Peso peso = new Peso();
				peso.setId(rs.getInt("id"));
				peso.setValor(rs.getDouble("valor"));
				peso.setTipoPeso(Peso.TipoPeso.values()[rs.getInt("tipo_peso")]);
				
				listaPeso.add(peso);
				PesoDAO.setListaPeso(listaPeso);
			}
		} catch (Exception e) {
			e.printStackTrace();
			listaPeso = null;
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (listaPeso == null || listaPeso.isEmpty())
			return null;
		
		return listaPeso;
	}

	@Override
	public Peso obterUm(Integer id) {
		Connection conn = DAO.getConnection();
		
		Peso peso = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  u.id, ");
		sql.append("  u.valor, ");
		sql.append("  u.tipo_peso, ");
		
		sql.append("FROM ");
		sql.append("  peso u ");
		sql.append("WHERE ");
		sql.append("  u.id = ? ");
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setInt(1, id);
			
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				peso = new Peso();
				peso.setId(rs.getInt("id"));
				peso.setValor(rs.getDouble("valor"));
				peso.setTipoPeso(Peso.TipoPeso.values()[rs.getInt("tipo_peso")]);					
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			peso = null;
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return peso;
	}

	

}
