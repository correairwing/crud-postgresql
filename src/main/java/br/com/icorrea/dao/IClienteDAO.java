package br.com.icorrea.dao;

import br.com.icorrea.domain.Cliente;

public interface IClienteDAO {

	public Integer cadastrar(Cliente cliente) throws Exception;
	
	
	public Cliente consultar(String codigo) throws Exception;


	public Integer excluir(Cliente cliente) throws Exception;
	
}
