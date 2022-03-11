package br.edu.infnet.bemseguro.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table(name = "TVeiculo")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo( 		
		use = JsonTypeInfo.Id.NAME, 		
		include = JsonTypeInfo.As.PROPERTY, 		
		property = "tipo")
@JsonSubTypes({ 	
	@JsonSubTypes.Type(value = Carro.class, name = "Carro"), 	
	@JsonSubTypes.Type(value = Motocicleta.class, name = "Motocicleta"), 
	@JsonSubTypes.Type(value = Caminhao.class, name = "Caminhao") 
})
public abstract class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String placa;
	private String uf;
	private String chassi;
	private String cor;
	
	@ManyToMany(mappedBy = "itensSegurados")
	@JsonIgnore
	private List<Apolice> apolices;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Veiculo() {
	}
	
	public Veiculo(Integer id, String placa, String uf, String chassi, String cor) {
		super();
		this.id = id;
		this.placa = placa;
		this.uf = uf;
		this.chassi = chassi;
		this.cor = cor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public List<Apolice> getApolices() {
		return apolices;
	}

	public void setApolices(List<Apolice> apolices) {
		this.apolices = apolices;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public abstract RiscoItem calcularRiscoDoItem();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(';');
		sb.append(this.placa);
		sb.append(';');
		sb.append(this.uf);
		sb.append(';');
		sb.append(this.chassi);
		sb.append(';');
		sb.append(this.cor);
		
		return sb.toString();
	}
}