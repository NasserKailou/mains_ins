CREATE OR REPLACE view public.v_pieces_jointe
AS
SELECT
pj.id, 

pj.type_piece, 

pj.chemin_piece, 

pj.who_done, 

pj.when_done, 

pj.on_deleted,

pj.id_detenu_pv,

pv.numero, 

pv.is_deleted,

pv.delais_traitement, 

pv.poursuivie_non
	FROM public.piecesjointe pj left join public."ProcesVerbal" pv 
			on pj.id_detenu_pv = pv.id;