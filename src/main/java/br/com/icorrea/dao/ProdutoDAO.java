package br.com.icorrea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.icorrea.dao.jdbc.ConnectionFactory;
import br.com.icorrea.domain.Produto;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Integer cadastrar(Produto produto) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_PRODUTO (ID, CODIGO, NOME) VALUES (nextval('SQ_PRODUTO'),?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, produto.getCodigo());
			ps.setString(2, produto.getNome());
			return ps.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			if(con != null && !con.isClosed()) {
				con.close();
			}
		}
	}

	@Override
	public Produto consultar(String codigo) throws Exception {
		Connection con = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	Produto produto = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_PRODUTO WHERE CODIGO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, codigo);
			rs = ps.executeQuery();
			if(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
			}
			return produto;
			
		} catch(Exception e) {
			throw e;
		} finally {
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			if(con != null && !con.isClosed()) {
				con.close();
			}
		}
	}
		

	@Override
	public Integer excluir(Produto produto) throws Exception {
		Connection con = null;
    	PreparedStatement ps = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, produto.getCodigo());
			return ps.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			if(con != null && !con.isClosed()) {
				con.close();
			}
		}
	}

	@Override
	public Integer atualizar(Produto produto) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "UPDATE TB_PRODUTO SET NOME = ?, CODIGO = ? WHERE ID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getCodigo());
			ps.setLong(3, produto.getId());
			return ps.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			if(con != null && !con.isClosed()) {
				con.close();
			}
		}
	}

	@Override
	public List<Produto> consultarTudo() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Produto> list = new ArrayList<>();
		Produto produto = null;
		
		try {
			con = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_PRODUTO";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();			
			while(rs.next()) {
				produto = new Produto();
				Long id = rs.getLong("ID");
				String nome = rs.getString("NOME");
				String cod = rs.getString("CODIGO");
				produto.setId(id);
				produto.setNome(nome);
				produto.setCodigo(cod);
				list.add(produto);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			if(con != null && !con.isClosed()) {
				con.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return list;
	}
	
}
