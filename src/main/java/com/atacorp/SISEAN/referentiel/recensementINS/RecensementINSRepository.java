package com.atacorp.SISEAN.referentiel.recensementINS;

import org.springframework.data.repository.CrudRepository;


public interface RecensementINSRepository extends CrudRepository<RecensementINS, Integer> {

	RecensementINS findByIdRecensementINS (Integer idRecensementINS);
	RecensementINS findByAnneeRecensement (Integer anneeRecensement);
	RecensementINS findByPopulationTotaleGreaterThanEqual (Integer populationTotale);
	RecensementINS findByPopulationHommeGreaterThanEqual (Integer populationHomme);
	RecensementINS findByPopulationFemmeGreaterThanEqual (Integer populationFemme);
	RecensementINS findByNombreMenageGreaterThanEqual (Integer nombreMenage);
	RecensementINS findByTauxAccroissementPopulationGreaterThanEqual (double tauxAccroissementPopulation);
	RecensementINS findByLocalite_codeLocalite (Integer codelocalite);
}
