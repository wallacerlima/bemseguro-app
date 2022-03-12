package br.edu.infnet.bemseguro.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.bemseguro.domain.model.Apolice;

@FeignClient(url = "localhost:8083/api/apolice", name = "apoliceClient")
public interface IApoliceClient {
	
	@GetMapping(value = "/listar")
	public List<Apolice> obterLista();
	
	@GetMapping(value = "/usuario/{idUser}/listar")
	public List<Apolice> obterLista(@PathVariable Integer idUser);
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Apolice apolice);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/{id}")
	public Apolice obterPorId(@PathVariable Integer id);
	
}
