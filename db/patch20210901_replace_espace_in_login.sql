UPDATE public.adherent
	SET telephone=replace(telephone,' ', '')
	WHERE id = id and telephone like '% %';
	
UPDATE public.users
	SET login=replace(login,' ','')
	WHERE login = login and login like '% %';