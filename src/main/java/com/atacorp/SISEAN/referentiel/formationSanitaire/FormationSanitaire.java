package com.atacorp.SISEAN.referentiel.formationSanitaire;

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
public class FormationSanitaire {

	@Id
	@NotNull
	private String NIFS;
	@NotNull
	private String denomination;
	@NotNull
	private String latitude;
	@NotNull
	private String longitude;
	@NotNull
	private Integer anneeCreation;
	@ManyToOne
    private Localite localite;
	@ManyToOne
    private TypeFormationSanitaire typeFormationSanitaire;
}
