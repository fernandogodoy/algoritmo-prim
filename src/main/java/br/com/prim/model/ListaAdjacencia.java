package br.com.prim.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ListaAdjacencia {

	private Set<Map<Vertice, List<Vertice>>> listaAdjacencia = new HashSet<>();

	public void add(Map<Vertice, List<Vertice>> adjacencia) {
		this.listaAdjacencia.add(adjacencia);
	}

	public int size() {
		return listaAdjacencia.size();
	}

	public List<Vertice> getAdjacentes(Vertice vertice) {
		return listaAdjacencia.stream()
				.filter(map -> map.containsKey(vertice))
				.findFirst()
				.map(map -> map.get(vertice))
				.orElse(Collections.emptyList());
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof ListaAdjacencia)) {
			return false;
		}
		ListaAdjacencia castOther = (ListaAdjacencia) other;
		return Objects.equals(listaAdjacencia, castOther.listaAdjacencia);
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaAdjacencia);
	}

}
