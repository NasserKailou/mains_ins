-- DROP VIEW public.v_adherent;

-- CREATE OR REPLACE VIEW public.v_adherent
--  AS
 SELECT ad.id,
    ad.nom_ad,
    ad.prenom_ad,
    ad.sexe,
    ad.matricule,
    (cat.code::text || '-'::text) || cat.libelle::text AS categorie,
    ad.fonction,
    ad.structure_sigle,
    ad.date_naiss,
	date_part('year'::text, age('2021-12-31'::timestamp, ad.date_naiss::timestamp with time zone)) AS age_2021,
	date_part('year'::text, age('2022-12-31'::timestamp, ad.date_naiss::timestamp with time zone)) AS age_2022,
	date_part('year'::text, age('2023-12-31'::timestamp, ad.date_naiss::timestamp with time zone)) AS age_2023,
    date_part('year'::text, age(now(), ad.date_naiss::timestamp with time zone)) AS age_2024,
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
