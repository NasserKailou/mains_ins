package com.atacorp.SISEAN.decoupageAdministratif.region;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.atacorp.SISEAN.decoupageAdministratif.departement.Departement;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Region {

	@Id	
	@NotNull
	private String codeRegion;
	@NotNull
	private String nomRegion;
	@OneToMany(mappedBy="region" , cascade = CascadeType.ALL)
    private Set<Departement> departements = new HashSet<>();
}
