package br.edu.infnet.bemseguro.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.bemseguro.domain.exception.PossuiKitGasException;

@Entity
@Table(name = "TCarro")
public class Carro extends Veiculo {
	
	private Boolean possuiKitGas;
	
	public Carro() {
	}
	
	public Carro(Integer id, String placa, String uf, String chassi, String cor) {
		super(id, placa, uf, chassi, cor);
	}

	public Boolean getPossuiKitGas() {
		return possuiKitGas;
	}

	public void setPossuiKitGas(Boolean possuiKitGas) {
		this.possuiKitGas = possuiKitGas;
		this.valida();
	}
	
	private void valida() {
		if (possuiKitGas == null) {
			throw new PossuiKitGasException("É obrigatório informar se o carro possui ou não kit gás!");
		}
	}

	@Override
	public RiscoItem calcularRiscoDoItem() {
		
		this.valida();

		if(this.possuiKitGas == true && this.getUf() == "RJ") {
			return RiscoItem.ALTO;
			
		} else if (this.possuiKitGas == true && this.getUf() == "SP") {
			return RiscoItem.MEDIO;
			
		} else {
			return RiscoItem.BAIXO;
			
		}
	}
	
	@Override
	public String toString() {
		return String.format("Carro: Placa: %s, Chassi: %s, Cor: %s, Possui Kit Gás? %b, Risco Item: %s",
				this.getPlaca(), this.getChassi(), this.getCor(), this.getPossuiKitGas(), this.calcularRiscoDoItem());
	}
}