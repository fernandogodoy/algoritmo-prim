package br.com.prim.printer;

import java.math.BigDecimal;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import br.com.prim.model.Aresta;
import br.com.prim.model.Arvore;
import br.com.prim.model.Vertice;

/**
 * 
 * @author Fernando
 *
 */
public class ConsolePrinter implements Printer {

	private Arvore arvore;

	public ConsolePrinter(Arvore arvore) {
		this.arvore = arvore;
	}

	@Override
	public void print() {
		Graph<Vertice, DefaultEdge> grafo = new DefaultDirectedGraph<>(DefaultEdge.class);

		for (Vertice vertice : arvore.getVertices()) {
			grafo.addVertex(vertice);
		}

		for (Aresta aresta : arvore.getArestas()) {
			grafo.addEdge(aresta.getOrigem(), aresta.getDestino());
		}

		System.out.println(grafo.toString());
		System.out.println("Z = " + calcularPesoTotal(arvore));
	}

	public BigDecimal calcularPesoTotal(Arvore arvore) {
		return arvore.getArestas().stream()
					.map(aresta -> aresta.getPeso())
					.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
