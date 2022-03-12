package br.edu.infnet.bemseguro.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.bemseguro.domain.model.Motocicleta;

@FeignClient(url = "localhost:8081/api/veiculo", name = "motocicletaClient")
public interface IMotocicletaClient {

	@GetMapping(value = "/motocicleta/listar")
	public List<Motocicleta> obterLista();
	
	@GetMapping(value = "/motocicleta/{idUser}/listar")
	public List<Motocicleta> obterLista(@PathVariable Integer idUser);
	
	@PostMapping(value = "/motocicleta/incluir")
	public void inserir(@RequestBody Motocicleta motocicleta);
	
	@DeleteMapping(value = "/motocicleta/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/motocicleta/{id}")
	public Motocicleta obterPorId(@PathVariable Integer id);
}
