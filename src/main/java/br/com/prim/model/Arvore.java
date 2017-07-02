package br.com.prim.model;

import java.util.ArrayList;
import java.util.List;

import br.com.fggraph.model.Tree;


/**
 * Representação da Árvore
 * 
 * @author Fernando
 *
 */
public class Arvore implements Tree<Aresta, Vertice> {

	private static final long serialVersionUID = 1L;

	private List<Aresta> arestas = new ArrayList<>();

	private List<Vertice> vertices = new ArrayList<>();

	@Override
	public void add(Aresta aresta) {
		this.arestas.add(aresta);
		this.vertices.add(aresta.getOrigin());
		this.vertices.add(aresta.getTarget());
	}

	public boolean isAdicionado(Vertice destino) {
		return this.getVertex().contains(destino);
	}

	@Override
	public final List<Vertice> getVertex() {
		return vertices;
	}

	@Override
	public final List<Aresta> getEdges() {
		return arestas;
	}


}
