package br.edu.infnet.bemseguro.tests;

import br.edu.infnet.bemseguro.domain.exception.PossuiKitGasException;
import br.edu.infnet.bemseguro.domain.model.Carro;

public class CarroTest {

	public static void main(String[] args) {
		
		try {
			
			Carro carro = new Carro(1, "QWE4822", "RJ", "DASRFDSF544545D", "Vermelho");
			carro.setPossuiKitGas(false);
			
			System.out.println(carro.calcularRiscoDoItem());
			
		} catch (PossuiKitGasException e) {
			e.printStackTrace();
		}
	}

}
