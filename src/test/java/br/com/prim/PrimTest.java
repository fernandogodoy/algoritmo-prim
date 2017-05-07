package br.com.prim;

import org.junit.Assert;
import org.junit.Test;

import br.com.prim.model.Grafo;
import br.com.prim.model.Vertice;
import br.com.prim.util.FileUtil;

/**
 * 
 * @author Fernando
 *
 */
public class PrimTest {

	@Test
	public void montaListaTest() {
		Grafo grafo = FileUtil.readFile();
		Assert.assertNotNull(grafo);
		Assert.assertEquals(11, grafo.getQtdArestas().intValue());
	}

	@Test
	public void selecionaAleatorioTest() {
		Grafo arvore = FileUtil.readFile();
		Assert.assertNotNull(arvore);
		Assert.assertNotNull(arvore.selecionarAleatorio());
	}

	@Test
	public void getAdjacentesTest() {
		Grafo arvore = FileUtil.readFile();
		Assert.assertNotNull(arvore);
		Assert.assertEquals(4, arvore.getAdjacentes(new Vertice("2")).size());
	}

}
