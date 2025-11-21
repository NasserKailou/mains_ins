package com.atacorp.SISEAN.decoupageAdministratif.localite;

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
public class LocaliteControllerAPI {
	@Autowired
	private LocaliteRepository localiteService;
	
	@GetMapping("/Localites")
	public Iterable<Localite>  all() 
	{
		try 
		{
			return localiteService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	@GetMapping("/Localites/{codeLocalite}")
	public Localite  one(@PathVariable String codeLocalite) 
	{
		try 
		{
			return localiteService.findByCodeLocalite(codeLocalite);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}
	
	@PostMapping("/Localites")
	 public Localite create(@Validated @RequestBody Localite localite)
	 { 
		try 
		{
			return localiteService.save(localite);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/Localites/{codeLocalite}")
	 public Localite replace (@PathVariable String codeLocalite,@Validated @RequestBody Localite localite)
	 { 
		 try 
			{
			 	Localite L = localiteService.findByCodeLocalite(codeLocalite);
			 	L.setCodeINS(localite.getCodeINS());
				L.setCodeLocalite(localite.getCodeLocalite());
				L.setNomLocalite(localite.getNomLocalite());
				L.setCommune(localite.getCommune());
				L.setLatitude(localite.getLatitude());
				L.setLongitude(localite.getLongitude());
				L.setLocalite(localite.getLocalite());
				L.setRataches(localite.getRataches());
				L.setTypeLocalite(localite.getTypeLocalite());
				return localiteService.save(L);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @DeleteMapping("/Localites")
	 public boolean  delete(@RequestParam String codeLocalite) 
	 {	
		 try 
			{
			 	localiteService.delete(localiteService.findByCodeLocalite(codeLocalite));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
