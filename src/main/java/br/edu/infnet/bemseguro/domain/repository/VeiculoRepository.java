package br.edu.infnet.bemseguro.domain.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bemseguro.domain.model.Veiculo;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {

	@Query("from Veiculo c where c.usuario.id = :userid")
	List<Veiculo> findAll(Integer userid, Sort by);

}
