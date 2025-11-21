CREATE OR REPLACE VIEW public.v_ecriture
 AS
 SELECT
 e.id as id_ecriture, e.ref_facture, e.date_operation, 
 e.compte, c.num_compte, c.libelle_compte, e.montant, e.type_operation, 
 e.designation, e.is_deleted, e.who_done, 
 e.when_done, j.libelle_journal, e.depense as id_depense, d.ref_depense, d.date_depense
 
 FROM public.ecriture e inner join  public.class_compte c on e.compte::character varying = c.num_compte
 	 inner join public.depense d on e.depense=d.id 
	 inner join public.journal_ecriture j ON j.id = e.journal