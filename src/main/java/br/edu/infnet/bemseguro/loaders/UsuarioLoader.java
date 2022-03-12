package br.edu.infnet.bemseguro.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.bemseguro.domain.model.Endereco;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader {

	@Autowired
	private UsuarioService usuarioService;

	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setEmail("wallacereislimaa@gmail.com");
		usuario.setNome("Wallace lima");
		usuario.setSenha("123456");
		usuario.setAdmin(true);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Logradouro teste");
		endereco.setLocalidade("Localidade teste");
		endereco.setBairro("Bairro teste");
		endereco.setUf("RJ");
		endereco.setComplemento("Complemento teste");
		endereco.setCep("25035090");
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);
		
	}
}