package modelo.curso_egresso;

import java.io.Serializable;

public class NomeCurso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	
	public NomeCurso() {
		super();
	}

	public NomeCurso(int id) {
		super();
		this.id = id;
	}

	public NomeCurso(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
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
		NomeCurso other = (NomeCurso) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}