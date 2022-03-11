package br.edu.infnet.bemseguro.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.bemseguro.domain.model.Segurado;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.service.SeguradoService;

@Component
@Order(2)
public class SeguradoLoader implements ApplicationRunner {

	@Autowired
	private SeguradoService seguradoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Segurado segurado = new Segurado("Wallace Lima", "12345678912", "wallacereislima@gmail.com");
		segurado.setUsuario(usuario);
		
		seguradoService.incluir(segurado);
		
	}
}