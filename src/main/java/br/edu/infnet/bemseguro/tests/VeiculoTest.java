package br.edu.infnet.bemseguro.tests;

import br.edu.infnet.bemseguro.domain.exception.PossuiAntiFurtoException;
import br.edu.infnet.bemseguro.domain.exception.PossuiKitGasException;
import br.edu.infnet.bemseguro.domain.exception.QuantidadeEixosInvalidaException;
import br.edu.infnet.bemseguro.domain.model.Caminhao;
import br.edu.infnet.bemseguro.domain.model.Carro;
import br.edu.infnet.bemseguro.domain.model.Motocicleta;

public class VeiculoTest {

	public static void main(String[] args) {
		
		
		try {
			Carro carro = new Carro(1, "QWE4822", "RJ", "DASRFDSF544545D", "Vermelho");
			carro.setPossuiKitGas(true);
			
			Motocicleta motocicleta = new Motocicleta(2, "TRE1236", "SP", "QWEWEQEWQEWQ33", "Azul");
			motocicleta.setDispositivoAntiFurto(false);
			
			Caminhao caminhao = new Caminhao(5, "ZXC1236", "SC", "MNNC455DOOENNF", "Branco");
			caminhao.setEixos(4);
			
			System.out.println(carro.toString());
			System.out.println(motocicleta.toString());
			System.out.println(caminhao.toString());
			
			
		} catch (PossuiKitGasException | PossuiAntiFurtoException | QuantidadeEixosInvalidaException e) {
			e.printStackTrace();
		}
	}
}