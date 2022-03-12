package br.edu.infnet.bemseguro.loaders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.bemseguro.domain.model.Apolice;
import br.edu.infnet.bemseguro.domain.model.Caminhao;
import br.edu.infnet.bemseguro.domain.model.Carro;
import br.edu.infnet.bemseguro.domain.model.Motocicleta;
import br.edu.infnet.bemseguro.domain.model.Segurado;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.model.Veiculo;
import br.edu.infnet.bemseguro.domain.service.ApoliceService;

@Component
@Order(4)
public class ApoliceLoader {

	@Autowired
	private ApoliceService apoliceService;

	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Segurado segurado = new Segurado();
		segurado.setId(1);
		
		Carro carro = new Carro();
		carro.setId(1);
		
		Motocicleta motocicleta = new Motocicleta();
		motocicleta.setId(2);
		
		Caminhao caminhao = new Caminhao();
		caminhao.setId(3);
		
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(carro);
		veiculos.add(motocicleta);
		veiculos.add(caminhao);
		
		
		Apolice apolice = new Apolice();
		apolice.setNumApolice("12345678910");
		apolice.setData(LocalDateTime.now());
		apolice.setTipo("Tradicional");
		apolice.setUsuario(usuario);
		apolice.setItensSegurados(veiculos);
		apolice.setSegurado(segurado);
		
		apoliceService.incluir(apolice);
	
	}
}