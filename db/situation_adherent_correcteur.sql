SELECT det.intitule, det.montant*0.8 as total, ad.nom_ad, ad.prenom_ad, det.when_done FROM public.reglement_detail det
inner join public.reglement reg on reg.id = det.reglement
inner join public.adherent ad on ad.id = reg.adherent
WHERE intitule like '%cor%'
order by ad.nom_ad,ad.prenom_ad, det.when_done DESC
