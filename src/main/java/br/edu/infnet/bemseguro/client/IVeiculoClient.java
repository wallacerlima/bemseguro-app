package br.edu.infnet.bemseguro.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.bemseguro.domain.model.Veiculo;

@FeignClient(url = "localhost:8081/api/veiculo", name = "veiculoClient")
public interface IVeiculoClient {

	@GetMapping(value = "/listar")
	public List<Veiculo> obterLista();

	@GetMapping(value = "/usuario/{idUser}/listar")
	public List<Veiculo> obterLista(@PathVariable Integer idUser);

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);

	@GetMapping(value = "/{id}")
	public Veiculo obterPorId(@PathVariable Integer id);
	
}
