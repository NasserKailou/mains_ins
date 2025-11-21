package com.atacorp.SISEAN.decoupageAdministratif.localite;

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
public class TypeLocalite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTypeLocalite;
	@NotNull
	private String libelleTypeLocalite;
}
