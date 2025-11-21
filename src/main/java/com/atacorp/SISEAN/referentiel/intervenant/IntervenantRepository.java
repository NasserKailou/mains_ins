package com.atacorp.SISEAN.referentiel.intervenant;

import org.springframework.data.repository.CrudRepository;

public interface IntervenantRepository extends CrudRepository<Intervenant, Integer> {

	Intervenant findByIdIntervenant(Integer idIntervenant);
	Intervenant findByDenomination(String denomination);
	Intervenant findByTypeIntervenant_IdTypeIntervenant(Integer idTypeIntervenant);
	Intervenant findByTypeIntervenant_LibelleTypeIntervenant(String libelleTypeIntervenant);
}
