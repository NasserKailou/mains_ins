package com.atacorp.SISEAN.decoupageAdministratif.localite;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Localites")
public class LocaliteController {

	@Autowired
	//@Resource
	private LocaliteRepository localiteService;
	
	@GetMapping("/listLocalites")
	public String listLocalites ( Model model) 
	{
		try
		{
			List<Localite> localites =  (List<Localite>) localiteService.findAll();
			model.addAttribute("localites", localites);
		}
		catch(Exception e)
		{
			
		}
		return "localite/listeLocalites";
	}
	
	@GetMapping("/addLocalites")
	public String  addLocalites( Model model) 
	{
		
		return "localite/addLocalites";
		
	}
	
	@PostMapping("/addLocalites")
    public String addLocalitesSubmit(@Validated Localite localite,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			Localite L = new Localite();
			L.setCodeINS(localite.getCodeINS());
			L.setCodeLocalite(localite.getCodeLocalite());
			L.setNomLocalite(localite.getNomLocalite());
			L.setCommune(localite.getCommune());
			L.setLatitude(localite.getLatitude());
			L.setLongitude(localite.getLongitude());
			L.setLocalite(localite.getLocalite());
			L.setRataches(localite.getRataches());
			L.setTypeLocalite(localite.getTypeLocalite());
			try
			{
				localiteService.save(L);
				List<Localite> localites =  (List<Localite>) localiteService.findAll();
				model.addAttribute("localites", localites);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<Localite> localites =  (List<Localite>) localiteService.findAll();
				model.addAttribute("localites", localites);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "localite/listeLocalites";
        
    }
	
	@GetMapping("/updateLocalites/{codeLocalite}")
    public String updateLocalites(@PathVariable("codeLocalite") String codeLocalite, Model model) 
	{ 
		try
		{
    		Localite localite =   localiteService.findByCodeLocalite(codeLocalite);
    		model.addAttribute("localite", localite);
		}
		catch(Exception e)
		{
			
		}
		return "localite/updateLocalites";
    		
    }
	
	@PostMapping("/updateLocalites/{codeLocalite}")
    public String updateLocalitesSubmit(@Validated Localite localite,BindingResult bindingResult,@PathVariable("codeLocalite") String codeLocalite, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
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
				localiteService.save(L);
				List<Localite> localites =  (List<Localite>) localiteService.findAll();
				model.addAttribute("localites", localites);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<Localite> localites =  (List<Localite>) localiteService.findAll();
			model.addAttribute("localites", localites);
    	}
		
    	return "localite/listeLocalites";
        
    }
	
	@GetMapping("/deleteLocalites/{codeLocalite}")
	public String deleteLocalites(@PathVariable("codeLocalite") String codeLocalite, Model model) 
	{ 
    	model.addAttribute("codeLocalite", codeLocalite);	
    	return "localite/deleteLocalites";
	    		
	}
	    
	@PostMapping("/deleteLocalites/{codeLocalite}")
	public String deleteLocalitesSubmit(@Validated BindingResult bindingResult,@PathVariable("codeLocalite") String codeLocalite, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			Localite L = localiteService.findByCodeLocalite(codeLocalite);
    			localiteService.delete(L);
    			List<Localite> localites =  (List<Localite>) localiteService.findAll();
    			model.addAttribute("localites", localites);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		Localite L = localiteService.findByCodeLocalite(codeLocalite);
			localiteService.delete(L);
			List<Localite> localites =  (List<Localite>) localiteService.findAll();
			model.addAttribute("localites", localites);
    	
    	}
    	return "localite/listeLocalites";
        
    }
}
