package services;

import java.util.List;

import com.google.inject.Inject;

import models.tables.daos.TypePrestationDao;
import models.tables.pojos.Reglement;
import models.tables.pojos.TypePrestation;
import utils.IConnectionHelper;

/**
 * 
 * @author nasser
 *
 */
public class TypePrestationMainService  extends TypePrestationDao{
private final IConnectionHelper con;
	
	@Inject
	public TypePrestationMainService(IConnectionHelper con) {
		super();
		this.con = con;
		
		setConfiguration(con.connection().configuration());
	}
	
	public TypePrestation findById(Long id) {
		return super.findById(id);
	}
	
	public List<TypePrestation> findAll() {
		List<TypePrestation> c = con.connection().selectFrom(models.Tables.TYPE_PRESTATION)
				.where(models.Tables.TYPE_PRESTATION.ON_DELETED.isFalse()).fetchInto(TypePrestation.class);
		con.connection().close();
		return c;
	}
}
