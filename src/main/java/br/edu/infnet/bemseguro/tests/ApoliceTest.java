package br.edu.infnet.bemseguro.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.bemseguro.domain.exception.PossuiAntiFurtoException;
import br.edu.infnet.bemseguro.domain.exception.PossuiKitGasException;
import br.edu.infnet.bemseguro.domain.exception.QuantidadeEixosInvalidaException;
import br.edu.infnet.bemseguro.domain.model.Apolice;
import br.edu.infnet.bemseguro.domain.model.Caminhao;
import br.edu.infnet.bemseguro.domain.model.Carro;
import br.edu.infnet.bemseguro.domain.model.Motocicleta;
import br.edu.infnet.bemseguro.domain.model.Segurado;
import br.edu.infnet.bemseguro.domain.model.Veiculo;

public class ApoliceTest {

	public static void main(String[] args) {
				
		Segurado segurado1 = new Segurado("Wallace Lima", "12345678912", "wallacereislima@gmail.com");
			
		Apolice apolice1 = new Apolice();
		apolice1.setId(1);
		apolice1.setNumApolice("123456");
		apolice1.setSegurado(segurado1);
			

		apolice1.setItensSegurados(obterItens());
			
		System.out.println(apolice1.toString());
			
	}
	
	public static List<Veiculo> obterItens() {
		
		List<Veiculo> itens = new ArrayList<>();
		
		try {
			Carro carro = new Carro(1, "QWE4822", "RJ", "DASRFDSF544545D", "Vermelho");
			carro.setPossuiKitGas(true);
			
			Motocicleta motocicleta = new Motocicleta(2, "TRE1236", "SP", "QWEWEQEWQEWQ33", "Azul");
			motocicleta.setDispositivoAntiFurto(false);
			
			Caminhao caminhao = new Caminhao(5, "ZXC1236", "SC", "MNNC455DOOENNF", "Branco");
			caminhao.setEixos(5);
			
			itens.add(carro);
			itens.add(motocicleta);
			itens.add(caminhao);
			
		} catch (PossuiKitGasException | PossuiAntiFurtoException | QuantidadeEixosInvalidaException e) {
			e.printStackTrace();
		}
	
		return itens;
	}
}
