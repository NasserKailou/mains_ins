package com.atacorp.SISEAN.referentiel.recensementINS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecensementINSControllerAPI {
	@Autowired
	private RecensementINSRepository recensementINSService;
	
	@GetMapping("/RecensementINSs")
	public Iterable<RecensementINS>  all() 
	{
		try 
		{
			return recensementINSService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	/*@GetMapping("/RecensementINSs/{idRecensementINS}")
	public RecensementINS  one(@PathVariable Integer idRecensementINS) 
	{
		try 
		{
			return recensementINSService.findByIdRecensementINS(idRecensementINS);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}*/
	
	@PostMapping("/RecensementINSs")
	 public RecensementINS create(@Validated @RequestBody RecensementINS recensementINS)
	 { 
		try 
		{
			return recensementINSService.save(recensementINS);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/RecensementINSs/{idRecensementINS}")
	 public RecensementINS replace (@PathVariable Integer idRecensementINS,@Validated @RequestBody RecensementINS recensementINS)
	 { 
		 try 
			{
			 	RecensementINS R = recensementINSService.findByIdRecensementINS(idRecensementINS);
				R.setIdRecensementINS(recensementINS.getIdRecensementINS());
				R.setAnneeRecensement(recensementINS.getAnneeRecensement());
				R.setPopulationTotale(recensementINS.getPopulationTotale());
				R.setPopulationHomme(recensementINS.getPopulationHomme());
				R.setPopulationFemme(recensementINS.getPopulationFemme());
				R.setTauxAccroissementPopulation(recensementINS.getTauxAccroissementPopulation());
				R.setNombreMenage(recensementINS.getNombreMenage());
				R.setLocalite(recensementINS.getLocalite());
				return recensementINSService.save(R);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @GetMapping("/RecensementINSs/{idRecensementINS}")
	 public boolean  delete(@PathVariable Integer idRecensementINS) 
	 {	
		 try 
			{
			 	recensementINSService.delete(recensementINSService.findByIdRecensementINS(idRecensementINS));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
