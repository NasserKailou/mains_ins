package com.atacorp.SISEAN.referentiel.intervenant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TypeIntervenant")
public class TypeIntervenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTypeIntervenant;
	@NotNull
	private String libelleTypeIntervenant;
}
