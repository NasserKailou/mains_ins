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
public class TypeEtablissementScolaireControllerAPI {
	@Autowired
	private TypeEtablissementScolaireRepository typeEtablissementScolaireService;
	
	@GetMapping("/TypeEtablissementScolaires")
	public Iterable<TypeEtablissementScolaire>  all() 
	{
		try 
		{
			return typeEtablissementScolaireService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/TypeEtablissementScolaires/{idTypeEtablissementScolaire}")
	public TypeEtablissementScolaire  one(@PathVariable Integer idTypeEtablissementScolaire) 
	{
		try 
		{
			return typeEtablissementScolaireService.findByIdTypeEtablissementScolaire(idTypeEtablissementScolaire);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/TypeEtablissementScolaires")
	 public TypeEtablissementScolaire create(@Validated @RequestBody TypeEtablissementScolaire typeEtablissementScolaire)
	 { 
		try 
		{
			return typeEtablissementScolaireService.save(typeEtablissementScolaire);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/TypeEtablissementScolaires/{idTypeEtablissementScolaire}")
	 public TypeEtablissementScolaire replace (@PathVariable Integer idTypeEtablissementScolaire,@Validated @RequestBody TypeEtablissementScolaire typeEtablissementScolaire)
	 { 
		 try 
			{
			 	TypeEtablissementScolaire TES = typeEtablissementScolaireService.findByIdTypeEtablissementScolaire(idTypeEtablissementScolaire);
				TES.setIdTypeEtablissementScolaire(typeEtablissementScolaire.getIdTypeEtablissementScolaire());
				TES.setLibelleTypeEtablissementScolaire(typeEtablissementScolaire.getLibelleTypeEtablissementScolaire());
				return typeEtablissementScolaireService.save(TES);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/TypeEtablissementScolaires/{idTypeEtablissementScolaire}")
	 public boolean  delete(@PathVariable Integer idTypeEtablissementScolaire) 
	 {	
		 try 
			{
			 	typeEtablissementScolaireService.delete(typeEtablissementScolaireService.findByIdTypeEtablissementScolaire(idTypeEtablissementScolaire));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
