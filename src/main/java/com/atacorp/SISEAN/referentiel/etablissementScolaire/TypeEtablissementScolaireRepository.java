package com.atacorp.SISEAN.referentiel.etablissementScolaire;

import org.springframework.data.repository.CrudRepository;

public interface TypeEtablissementScolaireRepository extends CrudRepository<TypeEtablissementScolaire, Integer> {

	TypeEtablissementScolaire findByIdTypeEtablissementScolaire(Integer idTypeEtablissementScolaire);
	TypeEtablissementScolaire findByLibelleTypeEtablissementScolaire(String libelleTypeEtablissementScolaire);
}
