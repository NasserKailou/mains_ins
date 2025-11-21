alter table public.categorie_compte add column is_for_budget boolean default false;
alter table public.class_compte add column is_for_budget boolean default false;


DROP TABLE IF EXISTS public.budget;

CREATE TABLE IF NOT EXISTS public.budget
(
    id bigserial NOT NULL ,
    gestion bigint NOT NULL,
    compte bigint,
    type_buget character varying COLLATE pg_catalog."default",
    montant bigint,
    is_Deleted boolean,
    who_done character varying COLLATE pg_catalog."default",
    when_done timestamp without time zone,
    CONSTRAINT budget_pkey PRIMARY KEY (id),
    CONSTRAINT unik_buget_row UNIQUE (gestion, compte, type_buget),
    CONSTRAINT fkey_compte_budget FOREIGN KEY (compte)
        REFERENCES public.class_compte (num_compte) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkey_gestion_buget FOREIGN KEY (gestion)
        REFERENCES public.params (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);



CREATE OR REPLACE VIEW public.v_budget
 AS
 SELECT  b.id ,
 	b.gestion as id_gestion,
	pp.gestion,
    b.compte ,
	e.libelle_compte,
    b.type_buget ,
    b.montant ,
    b."is_Deleted",
    b.who_done ,
    b.when_done
	from public.budget b inner join public.class_compte e on e.num_compte=b.compte
		inner join public.params pp on b.gestion = pp.id
 