package br.com.icorrea.dao;

import java.util.List;

import br.com.icorrea.domain.Cliente;

public interface IClienteDAO {

	public Integer cadastrar(Cliente cliente) throws Exception;
	
	
	public Cliente consultar(String codigo) throws Exception;


	public Integer excluir(Cliente cliente) throws Exception;
	
	
	public Integer atualizar(Cliente cliente) throws Exception;
	
	
	public List<Cliente> consultarTudo() throws Exception;
	
}
