package modelo.curso_egresso;

import java.io.Serializable;

public class Curso_Egresso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idCurso;
	private int anoIngresso;
	private int semestreIngresso;
	private int anoConcluido;
	private int semestreConcluido;
	private NomeCurso NCurso;
	private UnidadeSenac USenac;
	private TipoTitulo TTitulo;
	
	public Curso_Egresso() {
		super();
	}

	public Curso_Egresso(int idCurso) {
		super();
		this.idCurso = idCurso;
	}

	public Curso_Egresso(int idCurso, int anoIngresso, int semestreIngresso, int anoConcluido, int semestreConcluido,
			NomeCurso nCurso, UnidadeSenac uSenac, TipoTitulo tTitulo) {
		super();
		this.idCurso = idCurso;
		this.anoIngresso = anoIngresso;
		this.semestreIngresso = semestreIngresso;
		this.anoConcluido = anoConcluido;
		this.semestreConcluido = semestreConcluido;
		NCurso = nCurso;
		USenac = uSenac;
		TTitulo = tTitulo;
	}

	public final int getIdCurso() {
		return idCurso;
	}

	public final void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public final int getAnoIngresso() {
		return anoIngresso;
	}

	public final void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}

	public final int getSemestreIngresso() {
		return semestreIngresso;
	}

	public final void setSemestreIngresso(int semestreIngresso) {
		this.semestreIngresso = semestreIngresso;
	}

	public final int getAnoConcluido() {
		return anoConcluido;
	}

	public final void setAnoConcluido(int anoConcluido) {
		this.anoConcluido = anoConcluido;
	}

	public final int getSemestreConcluido() {
		return semestreConcluido;
	}

	public final void setSemestreConcluido(int semestreConcluido) {
		this.semestreConcluido = semestreConcluido;
	}

	public final NomeCurso getNCurso() {
		return NCurso;
	}

	public final void setNCurso(NomeCurso nCurso) {
		NCurso = nCurso;
	}

	public final UnidadeSenac getUSenac() {
		return USenac;
	}

	public final void setUSenac(UnidadeSenac uSenac) {
		USenac = uSenac;
	}

	public final TipoTitulo getTTitulo() {
		return TTitulo;
	}

	public final void setTTitulo(TipoTitulo tTitulo) {
		TTitulo = tTitulo;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCurso;
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
		Curso_Egresso other = (Curso_Egresso) obj;
		if (idCurso != other.idCurso)
			return false;
		return true;
	}
	
}