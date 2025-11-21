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
public class TypeLieuPubliqueControllerAPI {
	@Autowired
	private TypeLieuPubliqueRepository typeLieuPubliqueService;
	
	@GetMapping("/TypeLieuPubliques")
	public Iterable<TypeLieuPublique>  all() 
	{
		try 
		{
			return typeLieuPubliqueService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/TypeLieuPubliques/{idTypeLieuPublique}")
	public TypeLieuPublique  one(@PathVariable Integer idTypeLieuPublique) 
	{
		try 
		{
			return typeLieuPubliqueService.findByIdTypeLieuPublique(idTypeLieuPublique);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/TypeLieuPubliques")
	 public TypeLieuPublique create(@Validated @RequestBody TypeLieuPublique typeLieuPublique)
	 { 
		try 
		{
			return typeLieuPubliqueService.save(typeLieuPublique);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/TypeLieuPubliques/{idTypeLieuPublique}")
	 public TypeLieuPublique replace (@PathVariable Integer idTypeLieuPublique,@Validated @RequestBody TypeLieuPublique typeLieuPublique)
	 { 
		 try 
			{
			 	TypeLieuPublique TLP = typeLieuPubliqueService.findByIdTypeLieuPublique(idTypeLieuPublique);
				TLP.setIdTypeLieuPublique(typeLieuPublique.getIdTypeLieuPublique());
				TLP.setLibelleTypeLieuPublique(typeLieuPublique.getLibelleTypeLieuPublique());
				return typeLieuPubliqueService.save(TLP);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/TypeLieuPubliques/{idTypeLieuPublique}")
	 public boolean  delete(@PathVariable Integer idTypeLieuPublique) 
	 {	
		 try 
			{
			 	typeLieuPubliqueService.delete(typeLieuPubliqueService.findByIdTypeLieuPublique(idTypeLieuPublique));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
