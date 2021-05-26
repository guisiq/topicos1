package br.unitins.desafio.model.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

import br.unitins.desafio.model.Peso;
import br.unitins.desafio.model.Produto;

public class ProdutoDAO implements DAO<Produto>{


	@Override
	public boolean inserir(Produto obj) {
		Connection conn = DAO.getConnection();
		boolean deuErro = false;
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO produtos ");
		sql.append(" (nome,codiogo, preco,quant_estoque,data_fabricacao,data_vencimento,peso) ");
		sql.append("VALUES ");
		sql.append(" (?, ?, ?, ?, ?, ?,?) ");
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setString(1, obj.getNome());
			stat.setString(2, obj.getCodigo());
			stat.setDouble(3, obj.getPreco());
			stat.setDouble(4, obj.getQuantEstoque());
			if (obj.getDataFabricacao() == null)
				stat.setDate(5, null);
			else
				stat.setDate(5, Date.valueOf(obj.getDataFabricacao())); 
			
			if (obj.getDataVencimento() == null)
				stat.setDate(6, null);
			else
				stat.setDate(6, Date.valueOf(obj.getDataVencimento())); 
			
			if (obj.getPeso() == null)
				stat.setObject(6, null);
			else
			{
			
				PesoDAO aux = new PesoDAO();
				aux.inserir(obj.getPeso());			
				stat.setInt(6,obj.getPeso().getId());
				
			}
			
				
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
	public boolean alterar(Produto obj) {
		Connection conn = DAO.getConnection();
		boolean deuErro = false;
		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE produto SET ");
		// sql.append(" id = ?, ");
		sql.append(" codigo = ?, ");
		sql.append(" nome = ?, ");
		sql.append(" preco = ? ");
		sql.append(" quantidade_estoque = ?, ");
		sql.append(" peso = ?, ");
		sql.append(" data_fabricacao = ?, ");
		sql.append(" data_vencimento = ?, ");
		sql.append("WHERE ");
		sql.append(" id = ? ");
	
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setString(1, obj.getCodigo());
			stat.setString(2, obj.getNome());
			stat.setDouble(3, obj.getPreco());
			stat.setInt(4, obj.getQuantEstoque());
			
			if (obj.getPeso() == null)
				stat.setObject(5, null);
			else
			{
				{
					PesoDAO aux = new PesoDAO();
					aux.excluir(obj.getPeso().getId());
					aux.inserir(obj.getPeso());
				}
				stat.setInt(5,obj.getPeso().getId());
				
			}
			
			if (obj.getDataFabricacao() == null)
				stat.setDate(6, null);
			else
				stat.setDate(6, Date.valueOf(obj.getDataFabricacao())); 
			
			
			if (obj.getDataVencimento() == null)
				stat.setDate(7, null);
			else
				stat.setDate(7, Date.valueOf(obj.getDataVencimento())); 
			
			stat.setInt(8, obj.getId());
			
			stat.execute();
		} catch (Exception e) {
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
	public boolean excluir(Integer id) {
		Connection conn = DAO.getConnection();
		boolean deuErro = false;
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM produto WHERE id = ? ");
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setInt(1, id);
			
			stat.execute();
			//excluir o registro do peso asociado 
			// deichando por ultimo para nao xcluir um registro que e chave estrangeira na tabela produtos provavelmente ia dar erro 
			{
				List<Produto> produtos = this.obterTodos();
				produtos.removeIf(obj -> (obj.getId() != id));
				int idpeso = produtos.get(0).getPeso().getId();
				PesoDAO pesoDAO = new PesoDAO();
				pesoDAO.excluir(idpeso);
			}
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
	public List<Produto> obterTodos() {
		Connection conn = DAO.getConnection();
		List<Peso> listaPeso = PesoDAO.getListaPeso();
		List<Produto> listaProduto = new ArrayList<Produto>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  u.id, ");
		sql.append("  u.codigo, ");
		sql.append("  u.nome, ");
		sql.append("  u.preco, ");
		sql.append("  u.quantidade_estoque, ");
		sql.append("  u.peso, ");
		sql.append("  u.data_fabricacao, ");
		sql.append("  u.data_vencimento ");
		sql.append("FROM ");
		sql.append("  produtos u ");
		sql.append("ORDER BY u.id ");
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				
				Date data = rs.getDate("data_fabricacao");
				produto.setDataFabricacao(data == null ? null : data.toLocalDate());
				data = rs.getDate("data_vencimento");
				produto.setDataVencimento(data == null ? null : data.toLocalDate());
				
				produto.setPeso((new PesoDAO()).obterUm(rs.getInt("peso")));
					
				
				listaProduto.add(produto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			listaProduto = null;
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
		
		if (listaProduto == null || listaProduto.isEmpty())
			return null;
		
		return listaProduto;
	}
	
	@Override
	public Produto obterUm(Integer id) {
		Connection conn = DAO.getConnection();
		
		Produto produto = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  u.id, ");
		sql.append("  u.codigo, ");
		sql.append("  u.nome, ");
		sql.append("  u.preco, ");
		sql.append("  u.quantidade_estoque, ");
		sql.append("  u.data_fabricacao, ");
		sql.append("  u.data_vencimento ");
		sql.append("  u.peso, ");
		sql.append("FROM ");
		sql.append("  produtos u ");
		sql.append("WHERE ");
		sql.append("  u.id = ? ");
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setInt(1, id);
			
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantEstoque(rs.getInt("quantidade_estoque"));
				
				Date data = rs.getDate("data_fabricacao");
				produto.setDataFabricacao(data == null ? null : data.toLocalDate());
				data = rs.getDate("data_vencimento");
				produto.setDataVencimento(data == null ? null : data.toLocalDate());

				int idPeso = rs.getInt("peso");
				produto.setPeso((new PesoDAO()).obterUm(idPeso));						
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			produto = null;
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
		
		return produto;
	}
	
}
