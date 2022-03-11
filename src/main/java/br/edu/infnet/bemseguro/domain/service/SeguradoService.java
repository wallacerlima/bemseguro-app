package br.edu.infnet.bemseguro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.bemseguro.domain.model.Segurado;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.repository.SeguradoRepository;

@Service
public class SeguradoService {
	
	@Autowired
	private SeguradoRepository seguradoRepository;

	public List<Segurado> obterLista(){

		return (List<Segurado>) seguradoRepository.findAll();
	}
	
	public List<Segurado> obterLista(Usuario usuario){

		return (List<Segurado>) seguradoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public void incluir(Segurado segurado) {

		seguradoRepository.save(segurado);
	}
	
	public void excluir(Integer id) {

		seguradoRepository.deleteById(id);
	}
	
	public Segurado obterPorId(Integer id) {

		return seguradoRepository.findById(id).orElse(null);
	}
	
	public Long obterQtd() {
		return seguradoRepository.count();
	}
}