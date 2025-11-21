package com.atacorp.SISEAN.referentiel.lieuPublique;

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
public class LieuPublique {

	@Id
	@NotNull
	private String NILP;
	@NotNull
	private String denomination;
	@NotNull
	private String latitude;
	@NotNull
	private String longitude;
	@ManyToOne
    private Localite localite;
	@ManyToOne
    private TypeLieuPublique typeLieuPublique;
}
