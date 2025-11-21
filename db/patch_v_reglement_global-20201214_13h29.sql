DROP VIEW public.v_reglement_global;

CREATE OR REPLACE VIEW public.v_reglement_global
 AS
 SELECT  ad.matricule,
 	ad.nom_ad,
    ad.prenom_ad,
   
    sum(reg.montant) AS total_annuel,
    "substring"(reg.when_done::character varying::text, 1, 4)::character varying AS annee
   FROM reglement reg,
    adherent ad
  WHERE reg.adherent = ad.id AND reg.on_deleted IS FALSE
  GROUP BY ("substring"(reg.when_done::character varying::text, 1, 4)), ad.matricule, ad.nom_ad, ad.prenom_ad
  ORDER BY ad.matricule;