package br.com.prim.model;

import java.util.Objects;

import br.com.fggraph.model.Vertex;

/**
 * 
 * @author Fernando
 *
 */
public class Vertice implements Vertex {

	private static final long serialVersionUID = 1L;

	private String id;

	private boolean isVisitado;

	public Vertice(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return id;
	}

	public void visitado() {
		this.isVisitado = true;
	}

	public boolean isVisitado() {
		return isVisitado;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Vertice)) {
			return false;
		}
		Vertice castOther = (Vertice) other;
		return Objects.equals(id, castOther.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return id;
	}

}
