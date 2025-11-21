package com.atacorp.SISEAN.referentiel.etablissementScolaire;

import org.springframework.data.repository.CrudRepository;

public interface EtablissementScolaireRepository extends CrudRepository<EtablissementScolaire, String> {

	EtablissementScolaire findByNIES(String NIES);
	EtablissementScolaire findByDenomination(String denomination);
	EtablissementScolaire findByLocalite_codeLocalite(Integer codeLocalite);
}
