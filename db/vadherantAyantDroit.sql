CREATE OR REPLACE VIEW public.v_adherent_ayant_droit
 AS
 SELECT ad.id AS id_adherent,
    ad.nom_ad,
    ad.prenom_ad,
    ad.fonction,
    ad.date_naiss AS date_naiss_adherent,
    ad.date_prise_service,
    ad.picture AS picture_adherent,
    ad.direction,
    ad.division,
    ad.service,
    ad.telephone,
    ad.matricule,
    ad.structure,
    ad.structure_sigle,
    ad.code_programme,
    ad.categorie,
    ay.id AS id_ayant_droit,
    ay.nom_ay,
    ay.date_naiss AS date_naiss_ayant_droit,
    ay.adherent,
    ay.picture AS picture_ayant_droit,
    ay.lien,
    ay.genre
   FROM adherent ad,
    ayant_droit ay
  WHERE (ad.id = ay.adherent);
