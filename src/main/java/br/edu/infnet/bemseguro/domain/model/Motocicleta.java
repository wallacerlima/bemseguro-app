package br.edu.infnet.bemseguro.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.bemseguro.domain.exception.PossuiAntiFurtoException;

@Entity
@Table(name = "TMotocicleta")
public class Motocicleta extends Veiculo {

	private Boolean dispositivoAntiFurto;
	
	public Motocicleta() {
	}
	
	public Motocicleta(Integer id, String placa, String uf, String chassi, String cor) {
		super(id, placa, uf, chassi, cor);
	}

	public Boolean getDispositivoAntiFurto() {
		return dispositivoAntiFurto;
	}

	public void setDispositivoAntiFurto(Boolean dispositivoAntiFurto) {
		this.dispositivoAntiFurto = dispositivoAntiFurto;
		this.valida();
	}
	
	private void valida() {
		if (dispositivoAntiFurto == null) {
			throw new PossuiAntiFurtoException("É obrigatório informar se a motocicleta possui ou não dispositivo antifurto!");
		}
	}
	
	@Override
	public RiscoItem calcularRiscoDoItem() {
		
		this.valida();
		
		if(this.dispositivoAntiFurto == false && this.getUf() == "RJ") {
			return RiscoItem.ALTO;
			
		} else if (this.dispositivoAntiFurto == false && this.getUf() == "SP") {
			return RiscoItem.MEDIO;
			
		} else {
			return RiscoItem.BAIXO;
			
		}
	}
	
	@Override
	public String toString() {
		return String.format("Motocicleta: Placa: %s, Chassi: %s, Cor: %s, Possui Disp. Antifurto? %b, Risco Item: %s",
				this.getPlaca(), this.getChassi(), this.getCor(), this.getDispositivoAntiFurto(), this.calcularRiscoDoItem());
	}
}
