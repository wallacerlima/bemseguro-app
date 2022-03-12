package br.edu.infnet.bemseguro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.bemseguro.domain.model.Apolice;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.model.Veiculo;
import br.edu.infnet.bemseguro.domain.service.ApoliceService;
import br.edu.infnet.bemseguro.domain.service.SeguradoService;
import br.edu.infnet.bemseguro.domain.service.VeiculoService;

@Controller
public class ApoliceController {
	
	@Autowired
	private ApoliceService apoliceService;

	@Autowired
	private SeguradoService seguradoService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping(value = "/apolice")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
	    model.addAttribute("segurados", seguradoService.obterLista(usuario));
		
		model.addAttribute("veiculos", veiculoService.obterLista(usuario.getId()));

		return "apolice/cadastro";
	}
	
	@GetMapping(value = "/apolices")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", apoliceService.obterLista(usuario));
		
		return "apolice/lista";
	}

	@PostMapping(value = "/apolice/incluir")
	public String incluir(Model model, Apolice apolice, @RequestParam String[] veiculosId, @SessionAttribute("user") Usuario usuario) {

		List<Veiculo> veiculos = new ArrayList<>();
		
		for (String id : veiculosId) {
			veiculos.add(veiculoService.obterPorId(Integer.valueOf(id)));
		}
		
		apolice.setItensSegurados(veiculos);			
		apolice.setUsuario(usuario);			
		apoliceService.incluir(apolice);
		model.addAttribute("mensagem", "O apolice de número "+apolice.getNumApolice()+" foi cadastrada com sucesso!!!");
			
		return "redirect:/apolices";
	}

	@GetMapping(value = "/apolice/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Apolice apolice = apoliceService.obterPorId(id);		
		apoliceService.excluir(id);

		model.addAttribute("mensagem", "O apolice numero "+apolice.getId()+" foi removido com sucesso!!!");
		
		return telaLista(model, usuario);
	}
}
