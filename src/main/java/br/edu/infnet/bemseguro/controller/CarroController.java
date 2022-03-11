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

import br.edu.infnet.bemseguro.domain.model.Carro;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.service.CarroService;

@Controller
public class CarroController {

	List<Carro> carros = new ArrayList<Carro>();

	@Autowired
	private CarroService carroService;

	@GetMapping(value = "/carro")
	public String telaCadatro() {

		return "carro/cadastro";
	}

	@GetMapping(value = "/carros")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", carroService.obterLista(usuario));
		return "carro/lista";
	}

	@PostMapping(value = "/carro/incluir")
	public String incluir(Model model, Carro carro, @SessionAttribute("user") Usuario usuario) {

		carro.setUsuario(usuario);

		carroService.incluir(carro);
		model.addAttribute("mensagem", "O carro " + carro.getPlaca() + " foi cadastrado com sucesso!!!");
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/carro/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Carro carro = carroService.obterPorId(id);

		try {
			carroService.excluir(id);
			model.addAttribute("mensagem", "O carro " + carro.getPlaca() + " foi removido com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagemErro", "Impossivel remover o carro " + carro.getPlaca() + ", ele está associado à alguma apólice!!!");
		}

		return telaLista(model, usuario);
	}
}
