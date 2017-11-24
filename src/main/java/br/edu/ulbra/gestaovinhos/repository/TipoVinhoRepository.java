package br.edu.ulbra.gestaovinhos.repository;

import br.edu.ulbra.gestaovinhos.model.TipoVinho;
import br.edu.ulbra.gestaovinhos.model.User;
import org.springframework.data.repository.CrudRepository;

public interface TipoVinhoRepository extends CrudRepository<TipoVinho, Long> {
	TipoVinho findByDescricao(String descricao);
}
