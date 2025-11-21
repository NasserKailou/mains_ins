ALTER TABLE public.users ADD COLUMN connect_first BOOLEAN default true not null;
--UPDATE public.users	SET connect_first=true;