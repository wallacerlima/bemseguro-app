package br.edu.infnet.bemseguro.tests;

import br.edu.infnet.bemseguro.domain.exception.PossuiAntiFurtoException;
import br.edu.infnet.bemseguro.domain.model.Motocicleta;

public class MotocicletaTest {
	public static void main(String[] args) {
		
		try {

			Motocicleta motocicleta = new Motocicleta(2, "TRE1236", "SP", "QWEWEQEWQEWQ33", "Azul");
			motocicleta.setDispositivoAntiFurto(false);

			System.out.println(motocicleta.calcularRiscoDoItem());

		} catch (PossuiAntiFurtoException e) {
			e.printStackTrace();
		}
		
	}
}
