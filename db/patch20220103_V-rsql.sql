--01201.DROP VIEW public.v_reglement;

CREATE OR REPLACE VIEW public.v_reglement
 AS
 SELECT reg.id,
    ad.nom_ad,
    ad.prenom_ad,
    ad.id AS id_adherent,
    ad.matricule,
    reg.ref_facture,
    struc.libelle AS structure,
    reg.date_payement,
    reg.who_done,
    reg.when_done,
    "substring"(reg.date_payement::character varying::text, 1, 4)::character varying AS annee,
    reg.on_deleted,
    ty.prestation,
    ty.couverture,
    ay.nom_ay,
    ay.lien,
    ay.genre,
    reg.ayant_droit,
    COALESCE(( SELECT sum(COALESCE(reglement_detail.montant, 0::bigint)) AS sum
           FROM reglement_detail
          WHERE reglement_detail.reglement = reg.id), 0::bigint::numeric)::bigint AS montant_total,
    COALESCE(( SELECT sum(COALESCE(reglement_detail.montant, 0::bigint)) * ty.couverture::bigint::numeric / 100::numeric AS sum
           FROM reglement_detail
          WHERE reglement_detail.reglement = reg.id), 0::bigint::numeric)::bigint AS montant_reglement,
    COALESCE(( SELECT sum(COALESCE(reglement_detail.montant, 0::bigint)) * (100::bigint - ty.couverture::bigint)::numeric / 100::numeric AS sum
           FROM reglement_detail
          WHERE reglement_detail.reglement = reg.id), 0::bigint::numeric)::bigint AS montant_paye,
    struc.id AS id_structure
   FROM structure_partenaire struc,
    adherent ad,
    type_prestation ty,
    reglement reg
     LEFT JOIN ayant_droit ay ON reg.ayant_droit = ay.id
  WHERE reg.structure = struc.id AND reg.adherent = ad.id AND reg.type_prestation = ty.id
  ORDER BY reg.id;