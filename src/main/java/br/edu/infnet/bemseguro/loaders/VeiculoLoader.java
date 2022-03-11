 package br.edu.infnet.bemseguro.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.bemseguro.domain.model.Caminhao;
import br.edu.infnet.bemseguro.domain.model.Carro;
import br.edu.infnet.bemseguro.domain.model.Motocicleta;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.service.CaminhaoService;
import br.edu.infnet.bemseguro.domain.service.CarroService;
import br.edu.infnet.bemseguro.domain.service.MotocicletaService;

@Component
@Order(3)
public class VeiculoLoader implements ApplicationRunner {


	@Autowired
	private CarroService carroService;
	
	@Autowired
	private MotocicletaService motocicletaService;
	
	@Autowired
	private CaminhaoService caminhaoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);

		Carro carro = new Carro(1, "QWE4822", "RJ", "DASRFDSF544545D", "Vermelho");
		carro.setPossuiKitGas(true);
		carro.setUsuario(usuario);
				
		carroService.incluir(carro);
		
		Motocicleta motocicleta = new Motocicleta(2, "TRE1236", "SP", "QWEWEQEWQEWQ33", "Azul");
		motocicleta.setDispositivoAntiFurto(false);
		motocicleta.setUsuario(usuario);
				
		motocicletaService.incluir(motocicleta);
		
		Caminhao caminhao = new Caminhao(5, "ZXC1236", "SC", "MNNC455DOOENNF", "Branco");
		caminhao.setEixos(4);
		caminhao.setUsuario(usuario);
				
		caminhaoService.incluir(caminhao);
				
	
	}
}