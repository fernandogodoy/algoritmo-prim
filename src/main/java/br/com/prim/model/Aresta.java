package br.com.prim.model;

import java.math.BigDecimal;
import java.util.Objects;

import br.com.fggraph.model.Edge;

/**
 * 
 * @author Fernando
 *
 */
public class Aresta implements Edge {

	private static final long serialVersionUID = 1L;

	private Vertice origem;

	private Vertice destino;

	private BigDecimal peso;

	public Aresta(String origem, String destino, String peso) {
		this.origem = new Vertice(origem);
		this.destino = new Vertice(destino);
		this.peso = new BigDecimal(peso);
	}

	@Override
	public Vertice getOrigin() {
		return origem;
	}

	@Override
	public Vertice getTarget() {
		return destino;
	}

	@Override
	public BigDecimal getCost() {
		return peso;
	}

	@Override
	public String toString() {
		return "origem -> " + origem + " , destino -> " + destino + " = " + peso + "\n";
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Aresta)) {
			return false;
		}
		Aresta castOther = (Aresta) other;
		return Objects.equals(origem, castOther.origem) && Objects.equals(destino, castOther.destino)
				&& Objects.equals(peso, castOther.peso);
	}

	@Override
	public int hashCode() {
		return Objects.hash(origem, destino, peso);
	}

}
