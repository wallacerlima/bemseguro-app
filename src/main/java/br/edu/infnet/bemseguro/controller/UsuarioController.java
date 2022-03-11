package br.edu.infnet.bemseguro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.bemseguro.domain.model.Endereco;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/usuario")
	public String telaCadastro() {

		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuarios")
	public String telaLista(Model model) {
		
		model.addAttribute("lista", usuarioService.obterLista());		
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Model model, Usuario usuario, Endereco endereco) {
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		Usuario usuario = usuarioService.obterPorId(id);		
		usuarioService.excluir(id);
		model.addAttribute("mensagem", "O usuário "+usuario.getNome()+" foi removido com sucesso!!!");		
		
		return telaLista(model);
	}
}
