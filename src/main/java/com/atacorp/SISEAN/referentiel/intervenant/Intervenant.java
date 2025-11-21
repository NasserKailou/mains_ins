package com.atacorp.SISEAN.referentiel.intervenant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Intervenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIntervenant;
	@NotNull
	private String denomination;
	@ManyToOne
    private TypeIntervenant typeIntervenant;
}
