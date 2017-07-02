package br.com.prim.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Representação de um Grafo
 * 
 * @author Fernando
 *
 */
public class Grafo {

	private Set<Vertice> vertices = new HashSet<>();
	private Set<Aresta> arestas = new HashSet<>();

	public void add(Aresta aresta) {
		this.arestas.add(aresta);
		this.vertices.add(aresta.getOrigin());
		this.vertices.add(aresta.getTarget());
	}

	@Override
	public String toString() {
		return "Arvore [" + arestas + "], size: " + arestas.size();
	}

	/**
	 * Seleciona um vertice de forma aleatória
	 * 
	 * @return
	 */
	public Vertice selecionarAleatorio() {
		List<Vertice> list = new ArrayList<>(vertices);
		Collections.shuffle(list);
		return list.get(new Random().nextInt(vertices.size() - 1));
	}

	/**
	 * Lista todos vertices adjacentes ao vertice origem
	 * 
	 * @param vertices
	 * @return Vertices adjacentes ordenados por peso
	 */
	public List<Aresta> getAdjacentes(Vertice origem) {
		return arestas.stream().filter(aresta -> aresta.getOrigin().equals(origem)).sorted()
				.collect(Collectors.toList());
	}

	public List<Vertice> getVertices() {
		return new ArrayList<>(vertices);
	}

	public Integer getQtdArestas() {
		return arestas.size();
	}

}
