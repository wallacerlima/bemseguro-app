package br.edu.infnet.bemseguro.domain.model;

public abstract class Veiculo {
	
	private Integer id;
	private String placa;
	private String uf;
	private String chassi;
	private String cor;
	
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
	
	public String getPlaca() {
		return placa;
	}
	
	public String getUf() {
		return uf;
	}

	public String getChassi() {
		return chassi;
	}
	
	public String getCor() {
		return cor;
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