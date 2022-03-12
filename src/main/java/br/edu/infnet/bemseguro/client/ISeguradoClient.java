package br.edu.infnet.bemseguro.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.bemseguro.domain.model.Segurado;

@FeignClient(url = "localhost:8082/api/segurado", name = "seguradoClient")
public interface ISeguradoClient {

	@GetMapping(value = "/listar")
	public List<Segurado> obterLista();
	
	@GetMapping(value = "/usuario/{idUsuario}")
	public List<Segurado> obterListaPorUser(@PathVariable Integer idUsuario);
	
	@PostMapping(value = "/incluir")
	public void incluir(Segurado segurado);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/{id}")
	public Segurado obterPorId(@PathVariable Integer id);
}