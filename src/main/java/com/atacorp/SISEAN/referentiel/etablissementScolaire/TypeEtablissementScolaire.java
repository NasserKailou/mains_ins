package com.atacorp.SISEAN.referentiel.etablissementScolaire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypeEtablissementScolaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTypeEtablissementScolaire;
	@NotNull
	private String libelleTypeEtablissementScolaire;
}
