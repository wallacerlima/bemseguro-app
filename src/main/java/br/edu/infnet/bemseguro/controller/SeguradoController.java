package br.edu.infnet.bemseguro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.bemseguro.domain.model.Segurado;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.service.SeguradoService;

@Controller
public class SeguradoController {
	
	@Autowired
	private SeguradoService seguradoService;

	@GetMapping(value = "/segurado")
	public String telaCadastro() {

		return "segurado/cadastro";
	}
	
	@GetMapping(value = "/segurados")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", seguradoService.obterLista(usuario));
		
		return "segurado/lista";
	}

	@PostMapping(value = "/segurado/incluir")
	public String incluir(Model model, Segurado segurado, @SessionAttribute("user") Usuario usuario) {
		
		segurado.setUsuario(usuario);
		
		seguradoService.incluir(segurado);
		
		model.addAttribute("mensagem", "O segurado "+segurado.getNome()+" foi cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/segurado/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Segurado segurado = seguradoService.obterPorId(id);		
		seguradoService.excluir(id);

		model.addAttribute("mensagem", "O segurado "+segurado.getNome()+" foi removido com sucesso!!!");		
		
		return telaLista(model, usuario);
	}

}
