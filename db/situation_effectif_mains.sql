--TOTAL ADHERENT
CREATE OR REPLACE VIEW public.v_total_adherents
 AS
select count(id) as total_aherent, sexe from public.v_effectif_mains where age <=60 and id in(select adherent from public.reglement)
group by sexe

--Total Ayant droit conjoint
CREATE OR REPLACE VIEW public.v_total_ayant_droit_conjoint
 AS
select COUNT(id) as total_ayant_droit_conjoint ,lien from public.v_effectif_mains_ayant_droit 
where lien ='CONJOINT'
group by genre, lien

--Total Ayant droit enfant
CREATE OR REPLACE VIEW public.v_total_ayant_droit_enfant
 AS
select COUNT(id) as total_ayant_droit_enfant, lien	 from public.v_effectif_mains_ayant_droit 
where lien ='ENFANT' and age<=25
group by genre, lien

