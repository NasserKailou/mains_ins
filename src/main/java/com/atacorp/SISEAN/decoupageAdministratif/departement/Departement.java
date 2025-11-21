package com.atacorp.SISEAN.decoupageAdministratif.departement;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.atacorp.SISEAN.decoupageAdministratif.commune.Commune;
import com.atacorp.SISEAN.decoupageAdministratif.region.Region;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departement {

	@Id
	@NotNull
	private String codeDepartement;
	@NotNull
	private String nomDepartement;
	@ManyToOne
	@JoinColumn(name="codeRegion", nullable=false)
	private Region region;
	@OneToMany(mappedBy="departement" , cascade = CascadeType.ALL)
    private Set<Commune> communes = new HashSet<>();
	
}
