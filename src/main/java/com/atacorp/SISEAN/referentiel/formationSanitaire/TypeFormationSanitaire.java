package com.atacorp.SISEAN.referentiel.formationSanitaire;

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
public class TypeFormationSanitaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTypeFormationSanitaire;
	@NotNull
	private String libelleTypeFormationSanitaire;
}
