package com.atacorp.SISEAN.decoupageAdministratif.localite;

import org.springframework.data.repository.CrudRepository;

public interface TypeLocaliteRepository extends CrudRepository<TypeLocalite, Integer> {

	TypeLocalite findByIdTypeLocalite(Integer idTypeLocalite);
	TypeLocalite findByLibelleTypeLocalite(String libelleTypeLocalite);
}
