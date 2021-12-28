package br.edu.infnet.bemseguro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String incluir(Model model, Usuario usuario) {
		
		model.addAttribute("mensagem", "O usuário "+ usuario.getNome()+" foi cadastrado com sucesso!!!");
		
		usuarioService.incluir(usuario);
		return "redirect:/";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(HttpSession session, Model model, @PathVariable Integer id) {

		Usuario usuario = usuarioService.obterPorId(id);
		Usuario usuarioLogado = (Usuario)session.getAttribute("user");
		
		if(usuarioLogado.getId().equals(usuario.getId()) || usuario.isAdmin()) {
			model.addAttribute("errorMsg", "Não é possível excluir este usuário!");
		} else {
			usuarioService.excluir(id);
			model.addAttribute("mensagem", "O usuário "+usuario.getNome()+" foi removido com sucesso!!!");		
		}

		return telaLista(model);
	}
}
