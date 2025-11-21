package com.atacorp.SISEAN.decoupageAdministratif.localite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.atacorp.SISEAN.decoupageAdministratif.commune.Commune;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Localite {
	
	@Id
	@NotNull
	private String codeLocalite;
	@NotNull
	private String codeINS;
	@NotNull
	private String nomLocalite;
	@ManyToOne
	private Commune commune;
	@ManyToOne
	private TypeLocalite typeLocalite;
	private String latitude;
	private String longitude;
	//relation reflexive côté fils => localite parent
	@ManyToOne
    private Localite localite;
	//relation reflexive côté père => localite parent
    @OneToMany(mappedBy = "localite")
    private Set<Localite> rataches = new HashSet<>();
	

}
