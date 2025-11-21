package com.atacorp.SISEAN.decoupageAdministratif.region;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionForm {

	@NotNull(message ="{form.textField.notNull.message}")
	private String codeRegion;
	@NotNull(message = "{form.textField.notNull.message}")
	@Size(min=5, max=30,message = "{form.textField.minMax.message}")
	private String nomRegion;
}
