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

import br.edu.infnet.bemseguro.domain.model.Motocicleta;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.service.MotocicletaService;

@Controller
public class MotocicletaController {

	List<Motocicleta> motocicletas = new ArrayList<Motocicleta>();

	@Autowired
	private MotocicletaService motocicletaService;

	@GetMapping(value = "/motocicleta")
	public String telaCadatro() {

		return "motocicleta/cadastro";
	}

	@GetMapping(value = "/motocicletas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", motocicletaService.obterLista(usuario));
		return "motocicleta/lista";
	}

	@PostMapping(value = "/motocicleta/incluir")
	public String incluir(Model model, Motocicleta motocicleta, @SessionAttribute("user") Usuario usuario) {

		motocicleta.setUsuario(usuario);

		motocicletaService.incluir(motocicleta);
		model.addAttribute("mensagem", "A motocicleta " + motocicleta.getChassi() + " foi cadastrada com sucesso!");
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/motocicleta/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Motocicleta motocicleta = motocicletaService.obterPorId(id);

		try {
			motocicletaService.excluir(id);
			model.addAttribute("mensagem", "A motocicleta " + motocicleta.getPlaca() + " foi removida com sucesso!");
		} catch (Exception e) {
			model.addAttribute("mensagemErro", "Não foi possível remover a motocicleta " + motocicleta.getPlaca() + ", ela está associada à alguma apólice!");
		}

		return telaLista(model, usuario);
	}
}
