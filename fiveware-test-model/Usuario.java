package br.com.fiveware.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String nome;
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private String telefone;
	private char sexo;
	@JoinColumn(name = "id_estado_civil", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private UsuarioEstadoCivil usuarioEstadoCivil;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nome, Date dataNascimento,String telefone, char sexo, UsuarioEstadoCivil usuarioEstadoCivil) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.sexo = sexo;
		this.usuarioEstadoCivil = usuarioEstadoCivil;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public UsuarioEstadoCivil getUsuarioEstadoCivil() {
		return usuarioEstadoCivil;
	}

	public void setUsuarioEstadoCivil(UsuarioEstadoCivil usuarioEstadoCivil) {
		this.usuarioEstadoCivil = usuarioEstadoCivil;
	}
	
	

}
