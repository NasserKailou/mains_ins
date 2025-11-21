DROP VIEW public.v_adherent;

CREATE OR REPLACE VIEW public.v_adherent
 AS
 SELECT ad.id,
    ad.nom_ad,
    ad.prenom_ad,
    (cat.code::text || '-'::text) || cat.libelle::text AS categorie,
    ad.fonction,
    ad.structure_sigle,
    ad.date_naiss,
	date_part('year',age(now(), ad.date_naiss)) AS age,
    ad.date_prise_service,
	date_part('year',age(now(), ad.date_prise_service)) AS anciennete,
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

DROP VIEW public.v_ayant_droit;
CREATE OR REPLACE VIEW public.v_ayant_droit
 AS
 SELECT ay.id,
    ay.nom_ay,
    ay.date_naiss,
    date_part('year'::text, age(now(), ay.date_naiss::timestamp with time zone)) AS age,
    ay.adherent,
    (ad.nom_ad::text || '-'::text) || ad.prenom_ad::text AS nom_adherent,
	ad.matricule,
    ay.when_done,
    ay.who_done,
    ay.on_deleted,
    ay.picture,
    ay.lien,
    ay.genre
   FROM ayant_droit ay,
    adherent ad
  WHERE ad.id = ay.adherent;