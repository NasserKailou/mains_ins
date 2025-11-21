package com.atacorp.SISEAN.referentiel.intervenant;

import org.springframework.data.repository.CrudRepository;

public interface TypeIntervenantRepository extends CrudRepository<TypeIntervenant, Integer> {

	TypeIntervenant findByIdTypeIntervenant(Integer idTypeIntervenant);
	TypeIntervenant findByLibelleTypeIntervenant(String libelleTypeIntervenant);
}
