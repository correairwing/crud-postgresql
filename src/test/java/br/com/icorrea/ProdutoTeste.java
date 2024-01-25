package br.com.icorrea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.icorrea.dao.IProdutoDAO;
import br.com.icorrea.dao.ProdutoDAO;
import br.com.icorrea.domain.Produto;

public class ProdutoTeste {
	
	@Test
	public void cadastrarTest() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto prod = new Produto();
		prod.setCodigo("01");
		prod.setNome("produto 01");
		
		Integer countCad = dao.cadastrar(prod);
		assertTrue(countCad == 1);
		
		Produto prodBD = dao.consultar(prod.getCodigo());
		assertNotNull(prodBD);
		assertNotNull(prodBD.getId());
		assertEquals(prod.getCodigo(), prodBD.getCodigo());
		assertEquals(prod.getNome(), prodBD.getNome());
		
		Integer countDel = dao.excluir(prodBD);
		assertNotNull(countDel);
	}
	
	
}
