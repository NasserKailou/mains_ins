package com.atacorp.SISEAN.referentiel.lieuPublique;

import org.springframework.data.repository.CrudRepository;

public interface TypeLieuPubliqueRepository extends CrudRepository<TypeLieuPublique, Integer> {

	TypeLieuPublique findByIdTypeLieuPublique(Integer idTypeLieuPublique);
	TypeLieuPublique findByLibelleTypeLieuPublique(String libelleTypeLieuPublique);
}
