package br.com.icorrea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
	
	@Test
	public void excluirTest() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto prod = new Produto();
		prod.setCodigo("01");
		prod.setNome("Produto 01");
		Integer countCad = dao.cadastrar(prod);
		assertTrue(countCad == 1);
		
		Produto prodBD = dao.consultar("01");
		assertNotNull(prodBD);
		assertEquals(prod.getCodigo(), prodBD.getCodigo());
		assertEquals(prod.getNome(), prodBD.getNome());
		
		Integer countDel = dao.excluir(prodBD);
		assertTrue(countDel == 1);
		
		Integer countDel2 = dao.excluir(prodBD);
		assertNotNull(countDel2);
	}
	
	@Test
	public void consultarTest() throws Exception {
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto prod = new Produto();
		prod.setCodigo("01");
		prod.setNome("Produto 01");
		Integer countCad = dao.cadastrar(prod);
		assertTrue(countCad == 1);
		
		Produto prodBD = dao.consultar("01");
		assertNotNull(prodBD);
		assertEquals(prod.getCodigo(), prodBD.getCodigo());
		assertEquals(prod.getNome(), prodBD.getNome());
		
		Integer countDel = dao.excluir(prodBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void consultarTudoTest() throws Exception {
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto prod = new Produto();
		prod.setCodigo("01");
		prod.setNome("Produto 01");
		Integer countCad = dao.cadastrar(prod);
		assertTrue(countCad == 1);
		
		Produto outroProd = new Produto();
		outroProd.setCodigo("02");
		outroProd.setNome("Produto 02");
		Integer countCad2 = dao.cadastrar(outroProd);
		assertTrue(countCad2 == 1);
		
		List<Produto> list = dao.consultarTudo();
		assertNotNull(list);
		assertEquals(2, list.size());
		
		int countDel = 0;
		for(Produto p : list) {
			dao.excluir(p);
			countDel++;
		}
		assertEquals(list.size(), countDel);
		
		list = dao.consultarTudo();
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void atualizarTest() throws Exception {
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto prod = new Produto();
		prod.setCodigo("01");
		prod.setNome("Produto 01");
		Integer countCad = dao.cadastrar(prod);
		assertTrue(countCad == 1);
		
		Produto prodBD = dao.consultar("01");
		assertNotNull(prodBD);
		assertEquals(prod.getCodigo(), prodBD.getCodigo());
		assertEquals(prod.getNome(), prodBD.getNome());
		
		prodBD.setCodigo("02");
		prodBD.setNome("Produto 02");
		Integer countUpdate = dao.atualizar(prodBD);
		assertTrue(countUpdate == 1);
		
		Produto consult01 = dao.consultar("01");
		assertNull(consult01);
		
		Produto prodBD02 = dao.consultar("02");
		assertNotNull(prodBD02);
		assertEquals(prodBD.getId(), prodBD02.getId());
		assertEquals(prodBD.getNome(), prodBD02.getNome());
		assertEquals(prodBD.getCodigo(), prodBD02.getCodigo());
		
		Integer countDel = dao.excluir(prodBD);
		assertTrue(countDel == 1);
	}
}
































