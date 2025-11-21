package com.atacorp.SISEAN.referentiel.recensementINS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class RecensementINS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRecensementINS;
	@NotNull
	private Integer anneeRecensement;
	@NotNull
	private Integer populationTotale;
	@NotNull
	private Integer populationHomme;
	@NotNull
	private Integer populationFemme;
	@NotNull
	private Integer nombreMenage;
	@NotNull
	private double tauxAccroissementPopulation;
	@ManyToOne
    private Localite localite;

}
