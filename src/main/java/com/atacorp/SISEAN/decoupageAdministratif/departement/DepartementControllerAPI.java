package com.atacorp.SISEAN.decoupageAdministratif.departement;

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
public class DepartementControllerAPI {
	@Autowired
	private DepartementRepository departementService;
	
	@GetMapping("/Departements")
	public Iterable<Departement>  all() 
	{
		try 
		{
			return departementService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	@GetMapping("/Departements/{codeDepartement}")
	public Departement  one(@PathVariable String codeDepartement) 
	{
		try 
		{
			return departementService.findByCodeDepartement(codeDepartement);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}
	
	@PostMapping("/Departements")
	 public Departement create(@Validated @RequestBody Departement departement)
	 { 
		try 
		{
			return departementService.save(departement);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/Departements/{codeDepartement}")
	 public Departement replace (@PathVariable String codeDepartement,@Validated @RequestBody Departement departement)
	 { 
		 try 
			{
			 	Departement D = departementService.findByCodeDepartement(codeDepartement);
				D.setCodeDepartement(departement.getCodeDepartement());
				D.setNomDepartement(departement.getNomDepartement());
				D.setRegion(departement.getRegion());
				D.setCommunes(departement.getCommunes());
				return departementService.save(D);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @DeleteMapping("/Departements}")
	 public boolean  delete(@RequestParam String codeDepartement) 
	 {	
		 try 
			{
			 	departementService.delete(departementService.findByCodeDepartement(codeDepartement));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
