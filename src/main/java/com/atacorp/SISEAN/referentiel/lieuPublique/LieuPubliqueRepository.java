package com.atacorp.SISEAN.referentiel.lieuPublique;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuPubliqueRepository extends CrudRepository<LieuPublique, String> {

	LieuPublique findByNILP(String NILP);
	LieuPublique findByDenomination(String denomination);
	LieuPublique findByLocalite_CodeLocalite(String codeLocalite);
	LieuPublique findByTypeLieuPublique_idTypeLieuPublique(Integer idTypeLieuPublique);

	
}
