package br.com.prim;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.prim.model.Aresta;
import br.com.prim.model.Arvore;
import br.com.prim.model.Vertice;
import br.com.prim.printer.ConsolePrinter;
import br.com.prim.printer.JFramePrinter;
import br.com.prim.printer.Printer;
import br.com.prim.util.FileUtil;

/**
 * 
 * @author Fernando
 *
 */
public class Prim {

	private Arvore arvoreMinima = new Arvore();

	public static void main(String[] args) {
		Prim prim = new Prim();
		prim.execute();
		prim.printConsole();
		prim.printJFrame();
	}

	private void printJFrame() {
		Printer printer = new JFramePrinter(arvoreMinima);
		printer.print();
	}

	private void printConsole() {
		Printer printer = new ConsolePrinter(arvoreMinima);
		printer.print();
	}

	private void execute() {
		Arvore arvore = FileUtil.readFile();

		Vertice inicial = arvore.selecionarAleatorio();
		List<Aresta> arestasAdjacentes = arvore.getAdjacentes(Arrays.asList(inicial));
		Aresta aresta = findMenorCusto(arestasAdjacentes);

		while (arvoreMinima.getVertices().size() != arvore.getVertices().size()) {
			arvoreMinima.add(aresta);
			List<Aresta> adjacentes = arvore.getAdjacentes(arvoreMinima.getVertices());
			aresta = findMenorCusto(adjacentes);
		}
	}

	private Aresta findMenorCusto(List<Aresta> arestas) {
		BigDecimal custo = new BigDecimal(Long.MAX_VALUE);
		Aresta arestaMenorCusto = null;
		for (Aresta aresta : arestas) {
			if (custo.compareTo(aresta.getPeso()) == 1 && !arvoreMinima.isAdicionada(aresta)) {
				custo = aresta.getPeso();
				arestaMenorCusto = aresta;
			}
		}
		return arestaMenorCusto;
	}

	public Arvore getArvoreMinima() {
		return arvoreMinima;
	}
}
