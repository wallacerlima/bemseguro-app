package br.edu.infnet.bemseguro.tests;

import br.edu.infnet.bemseguro.domain.exception.QuantidadeEixosInvalidaException;
import br.edu.infnet.bemseguro.domain.model.Caminhao;

public class CaminhaoTest {

	public static void main(String[] args) {
		try {

			Caminhao caminhao = new Caminhao(5, "ZXC1236", "SC", "MNNC455DOOENNF", "Branco");
			caminhao.setEixos(4);

			System.out.println(caminhao.calcularRiscoDoItem());

		} catch (QuantidadeEixosInvalidaException e) {
			e.printStackTrace();
		}
	}

}