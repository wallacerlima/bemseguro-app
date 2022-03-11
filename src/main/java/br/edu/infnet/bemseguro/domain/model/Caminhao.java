package br.edu.infnet.bemseguro.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.bemseguro.domain.exception.QuantidadeEixosInvalidaException;

@Entity
@Table(name = "TCaminhao")
public class Caminhao extends Veiculo {

	private Integer eixos;
	
	public Caminhao() {
	}
	
	public Caminhao(Integer id, String placa, String uf, String chassi, String cor) {
		super(id, placa, uf, chassi, cor);
	}

	public Integer getEixos() {
		return eixos;
	}

	public void setEixos(Integer eixos) {
		this.eixos = eixos;
		this.valida();
	}
	
	private void valida() {
		if (eixos > 9) {
			throw new QuantidadeEixosInvalidaException("A quantidade de eixos informada não é válida!");
		}
	}
	
	@Override
	public RiscoItem calcularRiscoDoItem() {

		this.valida();
		
		if(this.eixos < 3 && this.getUf() == "RJ") {
			return RiscoItem.ALTO;
			
		} else if (this.eixos < 3 && this.getUf() == "SP") {
			return RiscoItem.MEDIO;
			
		} else {
			return RiscoItem.BAIXO;
			
		}
	}
	
	@Override
	public String toString() {
		return String.format("Caminhão: Placa: %s, Chassi: %s, Cor: %s, Eixos: %d, Risco Item: %s",
				this.getPlaca(), this.getChassi(), this.getCor(), this.getEixos(), this.calcularRiscoDoItem());
	}
}