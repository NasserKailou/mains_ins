package com.atacorp.SISEAN.decoupageAdministratif.commune;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommuneControllerAPI {
	@Autowired
	private CommuneRepository communeService;
	
	@GetMapping("/Communes")
	public Iterable<Commune>  all() 
	{
		try 
		{
			return communeService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	@GetMapping("/Communes/{codeCommune}")
	public Commune  one(@PathVariable String codeCommune) 
	{
		try 
		{
			return communeService.findByCodeCommune(codeCommune);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}
	
	@PostMapping("/Communes")
	 public Commune create(@Validated @RequestBody Commune commune)
	 { 
		try 
		{
			return communeService.save(commune);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/Communes/{codeCommune}")
	 public Commune replace (@PathVariable String codeCommune,@Validated @RequestBody Commune commune)
	 { 
		 try 
			{
			 	Commune C = communeService.findByCodeCommune(codeCommune);
				C.setCodeCommune(commune.getCodeCommune());
				C.setNomCommune(commune.getNomCommune());
				C.setDepartement(commune.getDepartement());
				C.setLocalites(commune.getLocalites());
				return communeService.save(C);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @DeleteMapping("/Communes")
	 public boolean  delete(@RequestParam String codeCommune) 
	 {	
		 try 
			{
			 	communeService.delete(communeService.findByCodeCommune(codeCommune));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
