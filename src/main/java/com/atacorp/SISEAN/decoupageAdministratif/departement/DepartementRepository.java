package com.atacorp.SISEAN.decoupageAdministratif.departement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, String>{

	Departement findByCodeDepartement(String codeDepartement);
	Departement findByNomDepartement(String nomDepartement);
}
