package br.com.prim.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representação da Árvore
 * 
 * @author Fernando
 *
 */
public class Arvore {

	private List<Aresta> arestas = new ArrayList<>();

	private List<Vertice> vertices = new ArrayList<>();

	public void add(Aresta aresta) {
		this.arestas.add(aresta);
		this.vertices.add(aresta.getOrigem());
		this.vertices.add(aresta.getDestino());
	}

	public boolean isAdicionado(Vertice destino) {
		return this.getVertices().contains(destino);
	}

	public final List<Vertice> getVertices() {
		return vertices;
	}

	public final List<Aresta> getArestas() {
		return arestas;
	}

}
