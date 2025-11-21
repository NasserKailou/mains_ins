CREATE TABLE IF NOT EXISTS public.categorie_compte
(
    id bigserial NOT NULL,
    num_categore bigint NOT NULL,
    libelle character varying COLLATE pg_catalog."default",
    is_deleted boolean,
    when_done timestamp without time zone,
    who_done character varying COLLATE pg_catalog."default",
    CONSTRAINT categorie_compte_pkey PRIMARY KEY (id),
    CONSTRAINT cat_unik_key UNIQUE (num_categore)
);

CREATE TABLE IF NOT EXISTS public.class_compte
(
    id bigserial NOT NULL ,
    categorie bigint NOT NULL,
    num_compte character varying COLLATE pg_catalog."default" NOT NULL,
    libelle_compte character varying COLLATE pg_catalog."default",
    description character varying COLLATE pg_catalog."default",
    is_deleted boolean,
    who_done character varying COLLATE pg_catalog."default",
    when_done timestamp without time zone,
    CONSTRAINT class_compte_pkey PRIMARY KEY (id),
    CONSTRAINT num_compte_unik UNIQUE (num_compte),
    CONSTRAINT fkey_categorie FOREIGN KEY (categorie)
        REFERENCES public.categorie_compte (num_categore) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);


CREATE TABLE IF NOT EXISTS public.depense
(
    id bigserial NOT NULL ,
    ref_depense character varying COLLATE pg_catalog."default",
    date_depense timestamp without time zone,
    is_deleted boolean NOT NULL,
    who_done character varying COLLATE pg_catalog."default",
    when_done timestamp without time zone,
    last_update timestamp without time zone,
    CONSTRAINT primary_depense PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS public.journal_ecriture
(
    id bigserial NOT NULL ,
    num_journal character varying COLLATE pg_catalog."default",
    libelle_journal character varying COLLATE pg_catalog."default",
    is_deleted boolean,
    who_done character varying COLLATE pg_catalog."default",
    when_done timestamp without time zone,
    CONSTRAINT journal_ecriture_pkey PRIMARY KEY (id),
    CONSTRAINT unik_journal_key UNIQUE (num_journal)
);


CREATE TABLE IF NOT EXISTS public.ecriture
(
    id bigserial NOT NULL ,
    ref_facture character varying COLLATE pg_catalog."default",
    date_operation timestamp without time zone,
    compte bigint,
    montant bigint,
    type_operation character varying COLLATE pg_catalog."default",
    designation character varying COLLATE pg_catalog."default",
    is_deleted boolean,
    who_done character varying COLLATE pg_catalog."default",
    when_done timestamp without time zone,
    journal bigint,
    depense bigint,
    CONSTRAINT ecriture_pkey PRIMARY KEY (id),
    CONSTRAINT cmpt_fkey FOREIGN KEY (compte)
        REFERENCES public.class_compte (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkey_depense FOREIGN KEY (depense)
        REFERENCES public.depense (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkey_journal FOREIGN KEY (journal)
        REFERENCES public.journal_ecriture (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);



