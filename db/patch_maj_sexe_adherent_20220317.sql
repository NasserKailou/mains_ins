DROP VIEW public.v_adherent;
  DROP VIEW public.v_adherent_ayant_droit;
CREATE OR REPLACE VIEW public.v_adherent
 AS
 SELECT ad.id,
    ad.nom_ad,
    ad.prenom_ad,
	ad.sexe,
    ad.matricule,
    (cat.code::text || '-'::text) || cat.libelle::text AS categorie,
    ad.fonction,
    ad.structure_sigle,
    ad.date_naiss,
    date_part('year'::text, age(now(), ad.date_naiss::timestamp with time zone)) AS age,
    ad.date_prise_service,
    date_part('year'::text, age(now(), ad.date_prise_service::timestamp with time zone)) AS anciennete,
    ad.picture,
    ad.when_done,
    ad.who_done,
    ad.on_deleted,
    dir.libelle AS direction,
    div.libelle AS division,
    serv.libelle AS service,
    ad.telephone
   FROM adherent ad,
    categorie cat,
    direction dir,
    division div,
    service serv
  WHERE cat.code::text = ad.categorie::text AND dir.id = ad.direction AND div.id = ad.division AND serv.id = ad.service;
  
  
  


CREATE OR REPLACE VIEW public.v_adherent_ayant_droit
 AS
 SELECT ad.id AS id_adherent,
    ad.nom_ad,
    ad.prenom_ad,
	ad.sexe,
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
  WHERE ad.id = ay.adherent;
