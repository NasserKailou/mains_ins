DROP VIEW public.v_reglement;
DROP VIEW public.v_reglement_global;

DROP TABLE public.reglement;




CREATE TABLE public.type_prestation
(
    id bigserial NOT NULL ,
    prestation character varying(255) COLLATE pg_catalog."default" NOT NULL,
    couverture character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT type_prestation_pkey PRIMARY KEY (id),
    CONSTRAINT type_prestation_prestation_key UNIQUE (prestation)
);



CREATE TABLE public.reglement
(
    id bigserial NOT NULL ,
    adherent bigint,
    ref_facture character varying COLLATE pg_catalog."default",
    structure bigint,
    date_payement timestamp without time zone,
    who_done character varying COLLATE pg_catalog."default",
    when_done timestamp without time zone,
    on_deleted boolean,
    type_prestation bigint,
    ayant_droit bigint,
    CONSTRAINT reglement_pkey PRIMARY KEY (id),
    CONSTRAINT reglement_ayant_droit_fkey FOREIGN KEY (ayant_droit)
        REFERENCES public.ayant_droit (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT reglement_type_prestation_fkey FOREIGN KEY (type_prestation)
        REFERENCES public.type_prestation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT structure_fky FOREIGN KEY (structure)
        REFERENCES public.structure_partenaire (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);



-- DROP TABLE public.reglement_detail;

CREATE TABLE public.reglement_detail
(
    id bigserial NOT NULL,
    reglement bigint,
    intitule character varying COLLATE pg_catalog."default",
    montant bigint,
    who_done character varying COLLATE pg_catalog."default",
    when_done timestamp without time zone,
    CONSTRAINT reglement_detail_pkey PRIMARY KEY (id)
);



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
    ("substring"(((reg.when_done)::character varying)::text, 1, 4))::character varying AS annee,
    reg.on_deleted
   FROM reglement reg,
    structure_partenaire struc,
    adherent ad
  WHERE ((reg.structure = struc.id) AND (reg.adherent = ad.id))
  ORDER BY reg.id;
  
  
  
  
  
CREATE OR REPLACE VIEW public.v_reglement_global
 AS
 SELECT ad.matricule,
    ad.nom_ad,
    ad.prenom_ad,
    0 AS total_annuel,
    ("substring"(((reg.when_done)::character varying)::text, 1, 4))::character varying AS annee
   FROM reglement reg,
    adherent ad
  WHERE ((reg.adherent = ad.id) AND (reg.on_deleted IS FALSE))
  GROUP BY ("substring"(((reg.when_done)::character varying)::text, 1, 4)), ad.matricule, ad.nom_ad, ad.prenom_ad
  ORDER BY ad.matricule;



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


DROP VIEW public.v_reglement;

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
    ("substring"(((reg.when_done)::character varying)::text, 1, 4))::character varying AS annee,
    reg.on_deleted,
    ty.prestation,
    ty.couverture,
    ay.nom_ay,
    ay.lien,
    ay.genre,
    reg.ayant_droit,
    (COALESCE(( SELECT sum(COALESCE(reglement_detail.montant, (0)::bigint)) AS sum
           FROM reglement_detail
          WHERE (reglement_detail.reglement = reg.id)), ((0)::bigint)::numeric))::bigint AS montant_total,
    (COALESCE(( SELECT ((sum(COALESCE(reglement_detail.montant, (0)::bigint)) * ((ty.couverture)::bigint)::numeric) / (100)::numeric) AS sum
           FROM reglement_detail
          WHERE (reglement_detail.reglement = reg.id)), ((0)::bigint)::numeric))::bigint AS montant_reglement,
    (COALESCE(( SELECT ((sum(COALESCE(reglement_detail.montant, (0)::bigint)) * (((100)::bigint - (ty.couverture)::bigint))::numeric) / (100)::numeric) AS sum
           FROM reglement_detail
          WHERE (reglement_detail.reglement = reg.id)), ((0)::bigint)::numeric))::bigint AS montant_paye
   FROM structure_partenaire struc,
    adherent ad,
    type_prestation ty,
    (reglement reg
     LEFT JOIN ayant_droit ay ON ((reg.ayant_droit = ay.id)))
  WHERE ((reg.structure = struc.id) AND (reg.adherent = ad.id) AND (reg.type_prestation = ty.id))
  ORDER BY reg.id;


