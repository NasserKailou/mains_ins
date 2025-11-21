-- Table: public.params

-- DROP TABLE IF EXISTS public.params;

CREATE TABLE IF NOT EXISTS public.params
(
    id bigserial,
    gestion character varying COLLATE pg_catalog."default" NOT NULL,
    plafond bigint NOT NULL,
    is_deleted boolean,
    CONSTRAINT params_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.params
    OWNER to postgres;