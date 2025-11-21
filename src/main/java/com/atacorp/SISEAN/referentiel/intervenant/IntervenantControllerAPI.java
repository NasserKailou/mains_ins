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
public class IntervenantControllerAPI {
	@Autowired
	private IntervenantRepository intervenantService;
	
	@GetMapping("/Intervenants")
	public Iterable<Intervenant>  all() 
	{
		try 
		{
			return intervenantService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/Intervenants/{idIntervenant}")
	public Intervenant  one(@PathVariable Integer idIntervenant) 
	{
		try 
		{
			return intervenantService.findByIdIntervenant(idIntervenant);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/Intervenants")
	 public Intervenant create(@Validated @RequestBody Intervenant intervenant)
	 { 
		try 
		{
			return intervenantService.save(intervenant);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/Intervenants/{idIntervenant}")
	 public Intervenant replace (@PathVariable Integer idIntervenant,@Validated @RequestBody Intervenant intervenant)
	 { 
		 try 
			{
			 	Intervenant I = intervenantService.findByIdIntervenant(idIntervenant);
				I.setIdIntervenant(intervenant.getIdIntervenant());
				I.setDenomination(intervenant.getDenomination());
				I.setTypeIntervenant(intervenant.getTypeIntervenant());
				return intervenantService.save(I);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/Intervenants/{idIntervenant}")
	 public boolean  delete(@PathVariable Integer idIntervenant) 
	 {	
		 try 
			{
			 	intervenantService.delete(intervenantService.findByIdIntervenant(idIntervenant));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
