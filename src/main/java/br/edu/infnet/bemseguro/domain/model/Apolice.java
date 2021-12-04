package br.edu.infnet.bemseguro.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Apolice {
	
	private Integer id;
	private String numApolice;
	private LocalDateTime data;
	private Segurado segurado;
	private List<Veiculo> itensSegurados;
	
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

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}
	
	public List<Veiculo> getItensSegurados() {
		return itensSegurados;
	}

	public void setItensSegurados(List<Veiculo> itensSegurados) {
		this.itensSegurados = itensSegurados;
	}

	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return String.format("Id: %d, Num. Apólice: %s, Data: %s, Nome segurado: %s, Itens segurados: %d",
				this.id, this.numApolice, this.data.format(formato), this.segurado.getNome(), this.itensSegurados.size());	
	}
}