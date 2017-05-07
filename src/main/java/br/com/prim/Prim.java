package br.com.prim;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.prim.model.Aresta;
import br.com.prim.model.Arvore;
import br.com.prim.model.Grafo;
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

	private Arvore arvore = new Arvore();
	private List<Aresta> adjacentes = new ArrayList<>();

	public static void main(String[] args) {
		Prim prim = new Prim();
		prim.execute();
		prim.printConsole();
		prim.printJFrame();
	}

	private void printJFrame() {
		Printer printer = new JFramePrinter(arvore);
		printer.print();
	}

	private void printConsole() {
		Printer printer = new ConsolePrinter(arvore);
		printer.print();
	}

	private void execute() {
		Grafo grafo = FileUtil.readFile();

		Vertice origem = grafo.selecionarAleatorio();
		Aresta aresta = selecionarAresta(grafo, origem);

		while (aresta != null) {
			arvore.add(aresta);
			origem = aresta.getDestino();
			aresta = selecionarAresta(grafo, origem);
		}
	}

	private Aresta selecionarAresta(Grafo grafo, Vertice origem) {
		adjacentes.addAll(grafo.getAdjacentes(origem));
		Aresta aresta = findByMenorCusto(adjacentes);
		return aresta;
	}

	private Aresta findByMenorCusto(List<Aresta> arestas) {
		BigDecimal custo = new BigDecimal(Long.MAX_VALUE);
		Aresta selecionada = null;
		for (Aresta aresta : arestas) {
			if (custo.compareTo(aresta.getPeso()) == 1 && !isVisitado(aresta)) {
				custo = aresta.getPeso();
				selecionada = aresta;
			}
		}
		return selecionada;
	}

	private boolean isVisitado(Aresta aresta) {
		return arvore.isAdicionado(aresta.getDestino()) && arvore.isAdicionado(aresta.getOrigem());
	}
}
