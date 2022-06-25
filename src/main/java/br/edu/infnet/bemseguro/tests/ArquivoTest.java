package br.edu.infnet.bemseguro.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class ArquivoTest {
	
	public static void main(String[] args) {

		try {
			String dir = "src/main/resources/";
			String arq = "arquivo.txt";

			try {
				FileReader fileR = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileR);

				FileWriter fileW = new FileWriter(dir + "out_" + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);

				Apolice apolice = new Apolice();
				List<Veiculo> itens = new ArrayList<Veiculo>();

				String linha = leitura.readLine();

				String[] campos = null;

				while (linha != null) {
					campos = linha.split(";");

					switch (campos[0]) {
					
					case "AS":
						apolice.setId(Integer.valueOf(campos[1]));
						apolice.setNumApolice(campos[2]);
						
						Segurado segurado = new Segurado(campos[3], campos[4], campos[5]);
						apolice.setSegurado(segurado);

						break;
					
					case "C":
						try {
							Carro carro = new Carro(Integer.valueOf(campos[1]), campos[2], campos[3], campos[4], campos[5]);
							carro.setPossuiKitGas(Boolean.valueOf(campos[6]));
							itens.add(carro);
							
						} catch (PossuiKitGasException e) {
							System.out.println(e.getMessage());

						}
						break;

					case "M":						
						try {
							Motocicleta motocicleta = new Motocicleta(Integer.valueOf(campos[1]), campos[2], campos[3], campos[4], campos[5]);
							motocicleta.setDispositivoAntiFurto(Boolean.valueOf(campos[6]));
							itens.add(motocicleta);
							
						} catch (PossuiAntiFurtoException e) {
							System.out.println(e.getMessage());
						}

						break;

					case "CA":
						try {
							Caminhao caminhao = new Caminhao(Integer.valueOf(campos[1]), campos[2], campos[3], campos[4], campos[5]);
							caminhao.setEixos(Integer.valueOf(campos[6]));
							
							itens.add(caminhao);

						} catch (QuantidadeEixosInvalidaException e) {
							System.out.println(e.getMessage() + "\r\n");
						}

						break;

					default:
						System.out.println("Tipo selecionado inválido!");
						break;
					}

					linha = leitura.readLine();

				}

				apolice.setItensSegurados(itens);	


				for (Veiculo item : apolice.getItensSegurados()) {
					escrita.write(item.getChassi());
					escrita.write(";");
					escrita.write(item.getCor());
					escrita.write(";");
					escrita.write(item.getPlaca());
					escrita.write("\r\n"); 
				}

				fileR.close();
				leitura.close();
				escrita.close();
				fileW.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Processamento realizado!");
		}

	}
	
}