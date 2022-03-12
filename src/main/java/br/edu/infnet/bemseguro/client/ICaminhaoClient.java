package br.edu.infnet.bemseguro.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.bemseguro.domain.model.Caminhao;

@FeignClient(url = "localhost:8081/api/veiculo", name = "caminhaoClient")
public interface ICaminhaoClient {

	@GetMapping(value = "/caminhao/listar")
	public List<Caminhao> obterLista();
	
	@PostMapping(value = "/caminhao/incluir")
	public void incluir(@RequestBody Caminhao caminhao);

	@PostMapping(value = "/caminhao/excluir/{id}")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/caminhao/{idUser}/listar")
	public List<Caminhao> obterLista(@PathVariable Integer idUser);

	@GetMapping(value = "/{id}/caminhao")
	public Caminhao obterPorId(@PathVariable Integer id);
}
