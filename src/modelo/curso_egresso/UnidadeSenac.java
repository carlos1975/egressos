package modelo.curso_egresso;

import java.io.Serializable;

public class UnidadeSenac implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nomeUnidade;
	
	public UnidadeSenac() {
		super();
	}

	public UnidadeSenac(int id) {
		super();
		this.id = id;
	}

	public UnidadeSenac(int id, String nomeUnidade) {
		super();
		this.id = id;
		this.nomeUnidade = nomeUnidade;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getNomeUnidade() {
		return nomeUnidade;
	}

	public final void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeSenac other = (UnidadeSenac) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
