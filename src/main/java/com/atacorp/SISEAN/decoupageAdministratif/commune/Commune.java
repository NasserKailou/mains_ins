package com.atacorp.SISEAN.decoupageAdministratif.commune;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.atacorp.SISEAN.decoupageAdministratif.departement.Departement;
import com.atacorp.SISEAN.decoupageAdministratif.localite.Localite;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commune {

	@Id
	@NotNull
	private String codeCommune;
	@NotNull
	private String nomCommune;	
	@ManyToOne
	@JoinColumn(name="codeDepartement", nullable=false)
	private Departement departement;
	@OneToMany(mappedBy="commune" , cascade = CascadeType.ALL)
    private Set<Localite> localites = new HashSet<>();
}
