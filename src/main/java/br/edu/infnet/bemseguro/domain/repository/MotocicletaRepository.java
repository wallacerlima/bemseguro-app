package br.edu.infnet.bemseguro.domain.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bemseguro.domain.model.Motocicleta;

@Repository
public interface MotocicletaRepository extends CrudRepository<Motocicleta, Integer> {

	@Query("from Motocicleta v where v.usuario.id = :userid")
	List<Motocicleta> findAll(Integer userid, Sort by);
	
	List<Motocicleta> findAll(Sort by);

}
