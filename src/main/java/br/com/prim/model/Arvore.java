package br.com.prim.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Arvore {

	private List<Aresta> arestas = new ArrayList<>();
	private Set<Vertice> vertices = new HashSet<>();

	public final List<Aresta> getArestas() {
		return arestas;
	}

	public void add(Aresta aresta) {
		this.arestas.add(aresta);
		this.vertices.add(aresta.getOrigem());
		this.vertices.add(aresta.getDestino());
	}

	@Override
	public String toString() {
		return "Arvore [" + arestas + "], size: " + arestas.size();
	}

	/**
	 * Seleciona um vertice inicial de forma aleatória
	 * 
	 * @return
	 */
	public Vertice selecionarAleatorio() {
		Collections.shuffle(arestas);
		return arestas.get(arestas.size() - 1).getOrigem();
	}

	/**
	 * Dada uma lista de vertices, retorna todos adicionados ligados aos
	 * vertices.
	 * 
	 * @param vertices
	 * @return
	 */
	public List<Aresta> getAdjacentes(List<Vertice> vertices) {
		return arestas.stream().filter(aresta -> vertices.contains(aresta.getOrigem())).collect(Collectors.toList());
	}

	public List<Vertice> getVertices() {
		return new ArrayList<>(vertices);
	}

	public boolean isAdicionada(Aresta aresta) {
		return this.getArestas().stream().filter(arest -> arest.isExistente(aresta)).findFirst().isPresent();
	}

}
