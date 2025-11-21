package com.atacorp.SISEAN.referentiel.lieuPublique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LieuPubliqueControllerAPI {
	@Autowired
	private LieuPubliqueRepository lieuPubliqueService;
	
	@GetMapping("/LieuPubliques")
	public Iterable<LieuPublique>  all() 
	{
		try 
		{
			return lieuPubliqueService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/LieuPubliques/{NILP}")
	public LieuPublique  one(@PathVariable String NILP) 
	{
		try 
		{
			return lieuPubliqueService.findByNILP(NILP);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/LieuPubliques")
	 public LieuPublique create(@Validated @RequestBody LieuPublique lieuPublique)
	 { 
		try 
		{
			return lieuPubliqueService.save(lieuPublique);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/LieuPubliques/{codeLieuPublique}")
	 public LieuPublique replace (@PathVariable String NILP,@Validated @RequestBody LieuPublique lieuPublique)
	 { 
		 try 
			{
			 	LieuPublique LP = lieuPubliqueService.findByNILP(NILP);
				LP.setDenomination(lieuPublique.getDenomination());
				LP.setLatitude(lieuPublique.getLatitude());
				LP.setLongitude(lieuPublique.getLongitude());
				LP.setLocalite(lieuPublique.getLocalite());
				LP.setTypeLieuPublique(lieuPublique.getTypeLieuPublique());
				return lieuPubliqueService.save(LP);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/LieuPubliques/{NILP}")
	 public boolean  delete(@PathVariable String NILP) 
	 {	
		 try 
			{
			 	lieuPubliqueService.delete(lieuPubliqueService.findByNILP(NILP));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
