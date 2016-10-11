package modelo.pessoa;

import java.io.Serializable;
import java.util.Date;

import modelo.endereco.Endereco;

public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idPessoa;
	private String nome;
	private String sobrenome;
	private Date data_de_nascimento;
	private String sexo;
	private String cpf;
	private Endereco endereco;
	private String situacao;
	private String email;
	private String telefone;
	
	public Pessoa() {
		super();
	}

	public Pessoa(int idPessoa) {
		super();
		this.idPessoa = idPessoa;
	}

	public Pessoa(int idPessoa, String nome, String sobrenome, Date data_de_nascimento, String sexo, String cpf,
			Endereco endereco) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.data_de_nascimento = data_de_nascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getData_de_nascimento() {
		return data_de_nascimento;
	}

	public void setData_de_nascimento(Date data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPessoa;
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
		Pessoa other = (Pessoa) obj;
		if (idPessoa != other.idPessoa)
			return false;
		return true;
	}
	
	
}
