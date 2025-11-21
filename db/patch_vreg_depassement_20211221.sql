-- View: public.v_reglement_globale

DROP VIEW public.v_reglement_globale;

CREATE OR REPLACE VIEW public.v_reglement_globale
 AS
 SELECT ad.matricule,
    ad.nom_ad,
    ad.prenom_ad,
    sum(reg.montant_reglement)::bigint AS total_annuel,
    reg.annee
   FROM v_reglement reg,
    adherent ad
  WHERE reg.id_adherent = ad.id AND reg.on_deleted IS FALSE
  GROUP BY reg.annee, ad.matricule, ad.nom_ad, ad.prenom_ad
  ORDER BY ad.matricule;



CREATE OR REPLACE VIEW public.v_depassement
 as 
 	SELECT * FROM public.v_reglement_globale
WHERE total_annuel > 350000;


