SELECT genre, count(id) as nombre_total FROM public.ayant_droit
where adherent in (select id from public.v_adherent where age <= 60)
group by genre


SELECT lien,genre ,count(id) as nombre_total FROM public.ayant_droit
where adherent in (select id from public.v_adherent where age <= 60)
group by lien ,genre


SELECT sexe, count(id) FROM public.v_adherent
where  age < 60 --id not in (select adherent from public.ayant_droit)
group by sexe

SELECT sexe,count(id) FROM public.v_adherent
where id not in (select adherent from public.reglement) and age < 60
group by sexe


SELECT * FROM public.v_adherent
where id not in (select adherent from public.reglement) and age < 60

SELECT * FROM public.adherent
where matricule not in (select matricule from public.personnel)



CREATE OR REPLACE FUNCTION public.maj_sexe_adherent()
    RETURNS character varying
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
DECLARE
ligne RECORD;

    BEGIN
     FOR ligne IN SELECT *  FROM  public.personnel 
  
   LOOP
		
UPDATE public.adherent  set sexe = ligne.sexe
	WHERE matricule::bigint = ligne.matricule::bigint;
 END LOOP;
      RETURN 'OK';
    END;
$BODY$;

select matricule, mat from public.adherent
--procdedure de mise à jour
UPDATE public.adherent  set mat = matricule::bigint
where id=id is null and matricule not in ('063')

select public.maj_sexe_adherent();

select nom_ad,prenom_ad ,matricule, sexe from public.adherent
WHERE sexe is null

UPDATE public.adherent  set sexe = 'M'
where sexe is null and matricule not in ('063')


UPDATE public.adherent  set sexe = 'F'
where sexe is null and matricule  in ('063')

--les adherents femme avec sexe masculin
select * from public.adherent where sexe ='M' and (nom_ad like'%Mme%' or prenom_ad like '%Mme%' or nom_ad like'%mme%' or prenom_ad like '%mme%')
--MAJ des adherents femme avec sexe masculin
UPDATE public.adherent  set sexe = 'F'
where sexe ='M' and (nom_ad like'%Mme%' or prenom_ad like '%Mme%' or nom_ad like'%mme%' or prenom_ad like '%mme%');
update 