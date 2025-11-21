Alter table public.adherent add column is_member boolean;
Alter table public.adherent add column is_ok_for_printing boolean;
Alter table public.ayant_droit add column is_ok_for_printing boolean;
UPDATE public.adherent
	SET   is_member=true, is_ok_for_printing=false ;

UPDATE public.ayant_droit
	SET  is_ok_for_printing=false ;


DROP VIEW public.v_adherent_ayant_droit;

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
	ay.is_ok_for_printing,
    ay.id AS id_ayant_droit,
    ay.nom_ay,
    ay.date_naiss AS date_naiss_ayant_droit,
    date_part('year'::text, age(now(), ad.date_naiss::timestamp with time zone)) AS age_adherent,
    date_part('year'::text, age(now(), ay.date_naiss::timestamp with time zone)) AS age,
    ay.adherent,
    ay.picture AS picture_ayant_droit,
    ay.lien,
    ay.genre
   FROM adherent ad,
    ayant_droit ay
  WHERE ad.id = ay.adherent;

CREATE OR REPLACE VIEW public.v_adherent_badges
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
	ad.is_ok_for_printing,
	ad.is_member,
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
