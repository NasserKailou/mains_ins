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
public class TypeFormationSanitaireControllerAPI {
	@Autowired
	private TypeFormationSanitaireRepository typeFormationSanitaireService;
	
	@GetMapping("/TypeFormationSanitaires")
	public Iterable<TypeFormationSanitaire>  all() 
	{
		try 
		{
			return typeFormationSanitaireService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/TypeFormationSanitaires/{idTypeFormationSanitaire}")
	public TypeFormationSanitaire  one(@PathVariable Integer idTypeFormationSanitaire) 
	{
		try 
		{
			return typeFormationSanitaireService.findByIdTypeFormationSanitaire(idTypeFormationSanitaire);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/TypeFormationSanitaires")
	 public TypeFormationSanitaire create(@Validated @RequestBody TypeFormationSanitaire typeFormationSanitaire)
	 { 
		try 
		{
			return typeFormationSanitaireService.save(typeFormationSanitaire);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/TypeFormationSanitaires/{idTypeFormationSanitaire}")
	 public TypeFormationSanitaire replace (@PathVariable Integer idTypeFormationSanitaire,@Validated @RequestBody TypeFormationSanitaire typeFormationSanitaire)
	 { 
		 try 
			{
			 	TypeFormationSanitaire TFS = typeFormationSanitaireService.findByIdTypeFormationSanitaire(idTypeFormationSanitaire);
				TFS.setIdTypeFormationSanitaire(typeFormationSanitaire.getIdTypeFormationSanitaire());
				TFS.setLibelleTypeFormationSanitaire(typeFormationSanitaire.getLibelleTypeFormationSanitaire());
				return typeFormationSanitaireService.save(TFS);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/TypeFormationSanitaires/{idTypeFormationSanitaire}")
	 public boolean  delete(@PathVariable Integer idTypeFormationSanitaire) 
	 {	
		 try 
			{
			 	typeFormationSanitaireService.delete(typeFormationSanitaireService.findByIdTypeFormationSanitaire(idTypeFormationSanitaire));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
