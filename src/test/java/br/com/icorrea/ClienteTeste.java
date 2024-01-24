package br.com.icorrea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import br.com.icorrea.dao.ClienteDAO;
import br.com.icorrea.dao.IClienteDAO;
import br.com.icorrea.domain.Cliente;

public class ClienteTeste {
	
	@Test
	public void cadastrarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("05");
		cliente.setNome("Irwing");
		
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
	}
	
	@Test
	public void excluirTest() throws Exception {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("05");
		cliente.setNome("Irwing");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);
		
		Cliente clienteBD = clienteDAO.consultar("05");
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = clienteDAO.excluir(clienteBD);
		assertTrue(countDel == 1);
		
		Integer qtdDel = clienteDAO.excluir(clienteBD);
		assertNotNull(qtdDel);
	}
		
	@Test
	public void consultarTest() throws Exception {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("05");
		cliente.setNome("Irwing");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);
		
		Cliente clienteBD = clienteDAO.consultar("05");
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = clienteDAO.excluir(clienteBD);
		assertTrue(countDel == 1);
	}
}
