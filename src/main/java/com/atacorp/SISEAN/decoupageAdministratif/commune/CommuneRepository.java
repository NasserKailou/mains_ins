package com.atacorp.SISEAN.decoupageAdministratif.commune;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepository extends CrudRepository<Commune, String>{

	Commune findByCodeCommune(String codeCommune);
	Commune findByNomCommune(String nomCommune);
}
