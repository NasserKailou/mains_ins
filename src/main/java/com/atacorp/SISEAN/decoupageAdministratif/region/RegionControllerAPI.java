package com.atacorp.SISEAN.decoupageAdministratif.region;

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
public class RegionControllerAPI {
	@Autowired
	private RegionRepository regionService;
	
	@GetMapping("/Regions")
	public Iterable<Region>  all() 
	{
		try 
		{
			return regionService.findAll();
		}
	    catch(Exception e)
		{
	    	return null;
		}
		
	}
	
	
	@GetMapping("/Regions/{codeRegion}")
	public Region  one(@PathVariable String codeRegion) 
	{
		try 
		{
			return regionService.findByCodeRegion(codeRegion);
		}
	    catch(Exception e)
		{
	    	return null;
		}
	
	}
	
	@PostMapping("/Regions")
	 public Region create(@Validated @RequestBody Region region)
	 { 
		try 
		{
			return regionService.save(region);
		}
	    catch(Exception e)
		{
	    	return null;
		}
		  
	 }
	
	 @PutMapping("/Regions/{codeRegion}")
	 public Region replace (@PathVariable String codeRegion,@Validated @RequestBody Region region)
	 { 
		 try 
			{
			 	Region R = regionService.findByCodeRegion(codeRegion);
				R.setCodeRegion(region.getCodeRegion());
				R.setNomRegion(region.getNomRegion());
				return regionService.save(R);
			}
		    catch(Exception e)
			{
		    	return null;
			}
		 
	 }
	 
	 @DeleteMapping("/Regions")
	 public boolean  delete(@RequestParam String codeRegion) 
	 {	
		 try 
			{
			 	regionService.delete(regionService.findByCodeRegion(codeRegion));
			 	return true; 
			}
		    catch(Exception e)
			{
		    	return false;
			}
		 
	 }
	

}
