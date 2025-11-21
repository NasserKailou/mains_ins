package com.atacorp.SISEAN.referentiel.formationSanitaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormationSanitaireControllerAPI {
	@Autowired
	private FormationSanitaireRepository formationSanitaireService;
	
	@GetMapping("/FormationSanitaires")
	public Iterable<FormationSanitaire>  all() 
	{
		try 
		{
			return formationSanitaireService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/FormationSanitaires/{NIFS}")
	public FormationSanitaire  one(@PathVariable String NIFS) 
	{
		try 
		{
			return formationSanitaireService.findByNIFS(NIFS);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/FormationSanitaires")
	 public FormationSanitaire create(@Validated @RequestBody FormationSanitaire formationSanitaire)
	 { 
		try 
		{
			return formationSanitaireService.save(formationSanitaire);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/FormationSanitaires/{codeFormationSanitaire}")
	 public FormationSanitaire replace (@PathVariable String NIFS,@Validated @RequestBody FormationSanitaire formationSanitaire)
	 { 
		 try 
			{
			 	FormationSanitaire FS = formationSanitaireService.findByNIFS(NIFS);
				FS.setDenomination(formationSanitaire.getDenomination());
				FS.setAnneeCreation(formationSanitaire.getAnneeCreation());
				FS.setLatitude(formationSanitaire.getLatitude());
				FS.setLongitude(formationSanitaire.getLongitude());
				FS.setLocalite(formationSanitaire.getLocalite());
				FS.setTypeFormationSanitaire(formationSanitaire.getTypeFormationSanitaire());
				return formationSanitaireService.save(FS);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/FormationSanitaires/{NIFS}")
	 public boolean  delete(@PathVariable String NIFS) 
	 {	
		 try 
			{
			 	formationSanitaireService.delete(formationSanitaireService.findByNIFS(NIFS));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
