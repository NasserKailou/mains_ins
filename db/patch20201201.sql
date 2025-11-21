INSERT INTO public.adherent(
	 nom_ad, prenom_ad, fonction, date_naiss, date_prise_service, when_done, who_done, on_deleted, telephone, matricule,structure,structure_sigle,code_programme)
	 (SELECT nom_ad, prenom_ad, fonction,  date_naiss::timestamp, date_prise_service::timestamp,'2020-12-01','admin_mutuel',false, telephone,matricule, structur,structure_sigle,programe
	FROM public.adherent_tmp where id > 273);