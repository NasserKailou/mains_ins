package com.atacorp.SISEAN.decoupageAdministratif.localite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaliteRepository extends CrudRepository<Localite, String> {

	Localite findByCodeLocalite(String codeLocalite);
	Localite findByNomLocalite(String nomLocalite);
}
