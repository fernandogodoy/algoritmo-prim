package br.com.prim;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import br.com.prim.model.Aresta;
import br.com.prim.model.Arvore;
import br.com.prim.model.Vertice;
import br.com.prim.util.FileUtil;

/**
 * 
 * @author Fernando
 *
 */
public class PrimTest {
	
	@Test
	public void montaListaTest(){
		Arvore arvore = FileUtil.readFile();
		Assert.assertNotNull(arvore);
		Assert.assertEquals(22, arvore.getArestas().size());
	}
	
	@Test
	public void selecionaAleatorioTest(){
		Arvore arvore = FileUtil.readFile();
		Assert.assertNotNull(arvore);
		Assert.assertNotNull(arvore.selecionarAleatorio());
	}
	
	@Test
	public void getAdjacentesTest(){
		Arvore arvore = FileUtil.readFile();
		Assert.assertNotNull(arvore);
		Assert.assertEquals(4, arvore.getAdjacentes(Arrays.asList(new Vertice("2"))).size());
		Assert.assertEquals(6, arvore.getAdjacentes(Arrays.asList(new Vertice("2"), new Vertice("6"))).size());
	}
	
	@Test
	public void isJaAdicionado(){
		Arvore arvore = FileUtil.readFile();
		Assert.assertNotNull(arvore);
		Prim prim = new Prim();
		Arvore arvoreMinima = prim.getArvoreMinima();
		arvoreMinima.add(new Aresta("1", "2", "10"));
		arvoreMinima.add(new Aresta("3", "4", "10"));
		arvoreMinima.add(new Aresta("5", "6", "10"));
		Assert.assertFalse(arvoreMinima.isAdicionada(new Aresta("4", "2", "10")));
		Assert.assertTrue(arvoreMinima.isAdicionada(new Aresta("2", "1", "10")));
		Assert.assertFalse(arvoreMinima.isAdicionada(new Aresta("2", "5", "10")));
	}
	
	
}
