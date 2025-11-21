package com.atacorp.SISEAN.referentiel.etablissementScolaire;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.atacorp.SISEAN.decoupageAdministratif.localite.Localite;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EtablissementScolaire {
	
	@Id
	@NotNull
	private String NIES;
	@NotNull
	private String denomination;
	private String latitude;
	private String longitude;
	@NotNull
	private Integer anneeCreation;
	@ManyToOne
    private Localite localite;
	@ManyToOne
    private TypeEtablissementScolaire typeEtablissementScolaire;
	

}
