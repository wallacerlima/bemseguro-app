package br.edu.infnet.bemseguro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.model.Veiculo;
import br.edu.infnet.bemseguro.domain.service.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping(value = "/veiculos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", veiculoService.obterLista(usuario));
		return "veiculo/lista";
	}

	@GetMapping(value = "/veiculo/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Veiculo veiculo = veiculoService.obterPorId(id);

		System.out.println(veiculo.getId());
		try {
			veiculoService.excluir(id);
			model.addAttribute("mensagem", "A veiculo " + veiculo.getPlaca() + " foi removido com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagemErro", "Impossivel remover o veiculo " + veiculo.getPlaca() + ", ele está associado à alguma apólice!!!");
		}

		return telaLista(model, usuario);
	}
}
