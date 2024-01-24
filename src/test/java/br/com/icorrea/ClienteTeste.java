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
		cliente.setCodigo("01");
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
	public void atualizarTest() throws Exception {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("5");
		cliente.setNome("Irwing");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);
		
		Cliente clienteDB = clienteDAO.consultar("5");
		assertNotNull(clienteDB);
		assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
		assertEquals(cliente.getNome(), clienteDB.getNome());
		
	}
}
