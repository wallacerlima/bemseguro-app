package br.edu.infnet.bemseguro.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.bemseguro.domain.model.Carro;

@FeignClient(url = "localhost:8081/api/veiculo", name = "carroClient")
public interface ICarroClient {

	@GetMapping(value = "/carro/listar")
	public List<Carro> obterLista();
	
	@GetMapping(value = "/carro/{id}/listar")
	public List<Carro> obterLista(@PathVariable Integer id);
	
	@PostMapping(value = "/carro/incluir")
	public void incluir(@RequestBody Carro carro);

	@GetMapping(value = "/carro/{id}")
	public Carro obterPorId(@PathVariable Integer id);
	
	@DeleteMapping(value = "/carro/excluir/{id}")
	public void excluir(@PathVariable Integer id);
		
}
