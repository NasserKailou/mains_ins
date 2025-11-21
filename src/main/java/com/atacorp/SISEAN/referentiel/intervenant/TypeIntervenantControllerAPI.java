package com.atacorp.SISEAN.referentiel.intervenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeIntervenantControllerAPI {
	@Autowired
	private TypeIntervenantRepository typeIntervenantService;
	
	@GetMapping("/TypeIntervenants")
	public Iterable<TypeIntervenant>  all() 
	{
		try 
		{
			return typeIntervenantService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/TypeIntervenants/{idTypeIntervenant}")
	public TypeIntervenant  one(@PathVariable Integer idTypeIntervenant) 
	{
		try 
		{
			return typeIntervenantService.findByIdTypeIntervenant(idTypeIntervenant);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/TypeIntervenants")
	 public TypeIntervenant create(@Validated @RequestBody TypeIntervenant typeIntervenant)
	 { 
		try 
		{
			return typeIntervenantService.save(typeIntervenant);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/TypeIntervenants/{idTypeIntervenant}")
	 public TypeIntervenant replace (@PathVariable Integer idTypeIntervenant,@Validated @RequestBody TypeIntervenant typeIntervenant)
	 { 
		 try 
			{
			 	TypeIntervenant TI = typeIntervenantService.findByIdTypeIntervenant(idTypeIntervenant);
				TI.setIdTypeIntervenant(typeIntervenant.getIdTypeIntervenant());
				TI.setLibelleTypeIntervenant(typeIntervenant.getLibelleTypeIntervenant());
				return typeIntervenantService.save(TI);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/TypeIntervenants/{idTypeIntervenant}")
	 public boolean  delete(@PathVariable Integer idTypeIntervenant) 
	 {	
		 try 
			{
			 	typeIntervenantService.delete(typeIntervenantService.findByIdTypeIntervenant(idTypeIntervenant));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
