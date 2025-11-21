package com.atacorp.SISEAN.referentiel.formationSanitaire;

import org.springframework.data.repository.CrudRepository;

public interface FormationSanitaireRepository extends CrudRepository<FormationSanitaire, String> {

	FormationSanitaire findByNIFS(String NIFS);
	FormationSanitaire findByDenomination(String denomination);
	FormationSanitaire findByLocalite_codeLocalite(Integer codeLocalite);
}
