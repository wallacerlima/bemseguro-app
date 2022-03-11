package br.edu.infnet.bemseguro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.bemseguro.domain.model.Motocicleta;
import br.edu.infnet.bemseguro.domain.model.Usuario;
import br.edu.infnet.bemseguro.domain.repository.MotocicletaRepository;

@Service
public class MotocicletaService {

	@Autowired
	private MotocicletaRepository motocicletaRepository;

	public List<Motocicleta> obterLista() {
		return motocicletaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public List<Motocicleta> obterLista(Usuario usuario) {
		 return (List<Motocicleta>) motocicletaRepository.findAll(usuario.getId(),
		 Sort.by(Sort.Direction.ASC, "id"));
	}

	public void incluir(Motocicleta motocicleta) {
		motocicletaRepository.save(motocicleta);
	}

	public void excluir(Integer id) {
		motocicletaRepository.deleteById(id);
	}

	public Motocicleta obterPorId(Integer id) {
		
		return motocicletaRepository.findById(id).orElse(null);
	}

	public Long obterQtd() {
		return motocicletaRepository.count();
	}
}