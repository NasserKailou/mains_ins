package com.atacorp.SISEAN.decoupageAdministratif.localite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeLocaliteControllerAPI {
	@Autowired
	private TypeLocaliteRepository typeLocaliteService;
	
	@GetMapping("/TypeLocalites")
	public Iterable<TypeLocalite>  all() 
	{
		try 
		{
			return typeLocaliteService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/TypeLocalites/{codeTypeLocalite}")
	public TypeLocalite  one(@PathVariable Integer idTypeLocalite) 
	{
		try 
		{
			return typeLocaliteService.findByIdTypeLocalite(idTypeLocalite);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/TypeLocalites")
	 public TypeLocalite create(@Validated @RequestBody TypeLocalite typeLocalite)
	 { 
		try 
		{
			return typeLocaliteService.save(typeLocalite);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/TypeLocalites/{codeTypeLocalite}")
	 public TypeLocalite replace (@PathVariable Integer idTypeLocalite,@Validated @RequestBody TypeLocalite typeLocalite)
	 { 
		 try 
			{
			 	TypeLocalite TL = typeLocaliteService.findByIdTypeLocalite(idTypeLocalite);
				TL.setIdTypeLocalite(typeLocalite.getIdTypeLocalite());
				TL.setLibelleTypeLocalite(typeLocalite.getLibelleTypeLocalite());
				return typeLocaliteService.save(TL);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/TypeLocalites/{codeTypeLocalite}")
	 public boolean  delete(@PathVariable Integer idTypeLocalite) 
	 {	
		 try 
			{
			 	typeLocaliteService.delete(typeLocaliteService.findByIdTypeLocalite(idTypeLocalite));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
