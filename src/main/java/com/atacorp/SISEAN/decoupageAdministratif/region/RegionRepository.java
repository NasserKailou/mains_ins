package com.atacorp.SISEAN.decoupageAdministratif.region;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository  extends CrudRepository<Region, String> {
	Region findByCodeRegion(String codeRegion);
	Region findByNomRegion(String nomRegion);
}
