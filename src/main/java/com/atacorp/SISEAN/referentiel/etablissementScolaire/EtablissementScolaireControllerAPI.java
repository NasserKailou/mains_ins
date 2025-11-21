package com.atacorp.SISEAN.referentiel.etablissementScolaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtablissementScolaireControllerAPI {
	@Autowired
	private EtablissementScolaireRepository etablissementScolaireService;
	
	@GetMapping("/EtablissementScolaires")
	public Iterable<EtablissementScolaire>  all() 
	{
		try 
		{
			return etablissementScolaireService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/EtablissementScolaires/{NIES}")
	public EtablissementScolaire  one(@PathVariable String NIES) 
	{
		try 
		{
			return etablissementScolaireService.findByNIES(NIES);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/EtablissementScolaires")
	 public EtablissementScolaire create(@Validated @RequestBody EtablissementScolaire etablissementScolaire)
	 { 
		try 
		{
			return etablissementScolaireService.save(etablissementScolaire);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/EtablissementScolaires/{codeEtablissementScolaire}")
	 public EtablissementScolaire replace (@PathVariable String NIES,@Validated @RequestBody EtablissementScolaire etablissementScolaire)
	 { 
		 try 
			{
			 	EtablissementScolaire ES = etablissementScolaireService.findByNIES(NIES);
				ES.setDenomination(etablissementScolaire.getDenomination());
				ES.setAnneeCreation(etablissementScolaire.getAnneeCreation());
				ES.setLatitude(etablissementScolaire.getLatitude());
				ES.setLongitude(etablissementScolaire.getLongitude());
				ES.setLocalite(etablissementScolaire.getLocalite());
				ES.setTypeEtablissementScolaire(etablissementScolaire.getTypeEtablissementScolaire());
				return etablissementScolaireService.save(ES);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/EtablissementScolaires/{NIES}")
	 public boolean  delete(@PathVariable String NIES) 
	 {	
		 try 
			{
			 	etablissementScolaireService.delete(etablissementScolaireService.findByNIES(NIES));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
