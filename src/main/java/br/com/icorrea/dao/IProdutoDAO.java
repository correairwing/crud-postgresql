package br.com.icorrea.dao;

import java.util.List;

import br.com.icorrea.domain.Produto;

public interface IProdutoDAO {
public Integer cadastrar(Produto produto) throws Exception;
	
	
	public Produto consultar(String codigo) throws Exception;


	public Integer excluir(Produto produto) throws Exception;
	
	
	public Integer atualizar(Produto produto) throws Exception;
	
	
	public List<Produto> consultarTudo() throws Exception;
}
