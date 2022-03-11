package br.edu.infnet.bemseguro.domain.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bemseguro.domain.model.Segurado;

@Repository
public interface SeguradoRepository extends CrudRepository<Segurado, Integer> {

	@Query("from Segurado s where s.usuario.id = :userid")
	public List<Segurado> findAll(Integer userid, Sort by);
}