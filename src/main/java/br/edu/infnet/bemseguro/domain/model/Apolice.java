package br.edu.infnet.bemseguro.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TApolice")
public class Apolice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numApolice;
	private String tipo;
	private LocalDateTime data;
	
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idSegurado")
	private Segurado segurado;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Veiculo> itensSegurados;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Apolice() {
		data = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumApolice() {
		return numApolice;
	}

	public void setNumApolice(String numApolice) {
		this.numApolice = numApolice;
	}

	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Veiculo> getItensSegurados() {
		return itensSegurados;
	}

	public void setItensSegurados(List<Veiculo> itensSegurados) {
		this.itensSegurados = itensSegurados;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return String.format("Id: %d, Num. Apólice: %s, Data: %s, Nome segurado: %s, Itens segurados: %d",
				this.id, this.numApolice, this.data.format(formato), this.segurado.getNome(), this.itensSegurados.size());	
	}
}