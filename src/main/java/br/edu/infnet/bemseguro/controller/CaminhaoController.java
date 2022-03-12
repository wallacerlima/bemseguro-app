package br.edu.infnet.bemseguro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.bemseguro.domain.model.Caminhao;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.service.CaminhaoService;

@Controller
public class CaminhaoController {

	List<Caminhao> caminhoes = new ArrayList<Caminhao>();
			
	@Autowired
	private CaminhaoService caminhaoService;

	@GetMapping(value = "/caminhao")
	public String telaCadatro() {

		return "caminhao/cadastro";
	}

	@GetMapping(value = "/caminhoes")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		
		model.addAttribute("lista", caminhaoService.obterLista(usuario));
		return "caminhao/lista";
	}

	@PostMapping(value = "/caminhao/incluir")
	public String incluir(Model model, Caminhao caminhao, @SessionAttribute("user") Usuario usuario) {

		caminhao.setUsuario(usuario);

		caminhaoService.incluir(caminhao);
		model.addAttribute("mensagem", "O caminhão " + caminhao.getPlaca() + " foi cadastrado com sucesso!");
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/caminhao/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Caminhao caminhao = caminhaoService.obterPorId(id);

		try {
			caminhaoService.excluir(id);
			model.addAttribute("mensagem", "O veículo " + caminhao.getPlaca() + " foi removida com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagemErro", "Não foi possível remover o caminhão " + caminhao.getPlaca() + ", ele está associado à alguma apólice!");
		}

		return telaLista(model, usuario);
	}
}
