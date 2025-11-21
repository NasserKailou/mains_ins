package services;

import java.util.List;

import javax.inject.Inject;

import org.jooq.DSLContext;

import models.tables.pojos.VCumuleByStructure;
import models.tables.pojos.VCumuleByTypePrestation;
import models.tables.pojos.VEffectifMains;
import models.tables.pojos.VEffectifMainsAyantDroit;
import models.tables.pojos.VTotalAdherents;
import models.tables.pojos.VTotalAyantDroitConjoint;
import models.tables.pojos.VTotalAyantDroitEnfant;
import utils.IConnectionHelper;

/**
 * Service pour récupérer les données du dashboard
 * @author nasser
 */
public class DashboardService {
	
	private final IConnectionHelper con;
	
	@Inject
	public DashboardService(IConnectionHelper con) {
		this.con = con;
	}
	
	/**
	 * Récupérer le total des adhérents
	 * @return
	 */
	public List<VTotalAdherents> getTotalAdherents() {
		List<VTotalAdherents> list = con.connection()
			.selectFrom(models.Tables.V_TOTAL_ADHERENTS)
			.fetchInto(VTotalAdherents.class);
		con.connection().close();
		return list;
	}
	
	/**
	 * Récupérer le total des ayants droit conjoints
	 * @return
	 */
	public List<VTotalAyantDroitConjoint> getTotalAyantDroitConjoints() {
		List<VTotalAyantDroitConjoint> list = con.connection()
			.selectFrom(models.Tables.V_TOTAL_AYANT_DROIT_CONJOINT)
			.fetchInto(VTotalAyantDroitConjoint.class);
		con.connection().close();
		return list;
	}
	
	/**
	 * Récupérer le total des ayants droit enfants
	 * @return
	 */
	public List<VTotalAyantDroitEnfant> getTotalAyantDroitEnfants() {
		List<VTotalAyantDroitEnfant> list = con.connection()
			.selectFrom(models.Tables.V_TOTAL_AYANT_DROIT_ENFANT)
			.fetchInto(VTotalAyantDroitEnfant.class);
		con.connection().close();
		return list;
	}
	
	/**
	 * Récupérer les cumuls par structure pour une année donnée
	 * @param gestion
	 * @return
	 */
	public List<VCumuleByStructure> getCumuleByStructure(String gestion) {
		List<VCumuleByStructure> list = con.connection()
			.selectFrom(models.Tables.V_CUMULE_BY_STRUCTURE)
			.where(models.Tables.V_CUMULE_BY_STRUCTURE.ANNEE.eq(gestion))
			.orderBy(models.Tables.V_CUMULE_BY_STRUCTURE.TOTAL_ANNUEL.desc())
			.fetchInto(VCumuleByStructure.class);
		con.connection().close();
		return list;
	}
	
	/**
	 * Récupérer les cumuls par type de prestation pour une année donnée
	 * @param gestion
	 * @return
	 */
	public List<VCumuleByTypePrestation> getCumuleByTypePrestation(String gestion) {
		List<VCumuleByTypePrestation> list = con.connection()
			.selectFrom(models.Tables.V_CUMULE_BY_TYPE_PRESTATION)
			.where(models.Tables.V_CUMULE_BY_TYPE_PRESTATION.ANNEE.eq(gestion))
			.orderBy(models.Tables.V_CUMULE_BY_TYPE_PRESTATION.TOTAL_ANNUEL.desc())
			.fetchInto(VCumuleByTypePrestation.class);
		con.connection().close();
		return list;
	}
	
	/**
	 * Compter le nombre total d'adhérents actifs
	 * @return
	 */
	public Long countAdherents() {
		Long count = con.connection()
			.selectCount()
			.from(models.Tables.V_EFFECTIF_MAINS)
			.where(models.Tables.V_EFFECTIF_MAINS.ON_DELETED.isFalse())
			.fetchOneInto(Long.class);
		con.connection().close();
		return count != null ? count : 0L;
	}
	
	/**
	 * Compter le nombre total d'ayants droit actifs
	 * @return
	 */
	public Long countAyantsDroit() {
		Long count = con.connection()
			.selectCount()
			.from(models.Tables.V_EFFECTIF_MAINS_AYANT_DROIT)
			.where(models.Tables.V_EFFECTIF_MAINS_AYANT_DROIT.ON_DELETED.isFalse())
			.fetchOneInto(Long.class);
		con.connection().close();
		return count != null ? count : 0L;
	}
}
