package modelo.curso_egresso;

import java.io.Serializable;

public class TipoTitulo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String tipo;
	
	public TipoTitulo() {
		super();
	}

	public TipoTitulo(int id) {
		super();
		this.id = id;
	}

	public TipoTitulo(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getTipo() {
		return tipo;
	}

	public final void setTipo(String tipo) {
		this.tipo = tipo;
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
		TipoTitulo other = (TipoTitulo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
