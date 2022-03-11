package br.edu.infnet.bemseguro.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TUsuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	private String nome;
	
	@Column(unique=true)
	private String email;
	
	private String senha;
	
	private boolean admin;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	@JsonBackReference(value="usuario-client")
	private List<Segurado> segurados;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	@JsonBackReference(value="user-veiculos")
	private List<Veiculo> veiculos;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	@JsonBackReference(value="user-apolice")
	private List<Apolice> apolices;
	
	public Usuario() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Segurado> getSegurados() {
		return segurados;
	}

	public void setSolicitantes(List<Segurado> segurados) {
		this.segurados = segurados;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Apolice> getApolices() {
		return apolices;
	}

	public void setApolices(List<Apolice> apolices) {
		this.apolices = apolices;
	}

	public void setSegurados(List<Segurado> segurados) {
		this.segurados = segurados;
	}

	@Override
	public String toString() {
		return String.format("Olá, %s (%s) %s", this.nome, this.email, this.admin ? "*" : "");
	}
}
