UPDATE public.adherent
SET matricule = regexp_replace(matricule, '^0+', '')
WHERE matricule ~ '^0';

--ajouter un zero au deuxieme numero trouver

UPDATE public.adherent a
SET matricule = a.matricule || '0'
WHERE a.id NOT IN (
    SELECT MIN(id)
    FROM public.adherent
    GROUP BY matricule
    HAVING COUNT(*) > 1
)
AND a.matricule IN (
    SELECT matricule
    FROM public.adherent
    GROUP BY matricule
    HAVING COUNT(*) > 1
);

