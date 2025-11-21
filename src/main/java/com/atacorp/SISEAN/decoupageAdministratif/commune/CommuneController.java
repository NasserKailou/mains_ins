package com.atacorp.SISEAN.decoupageAdministratif.commune;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommuneController {

	@Autowired
	private CommuneRepository communeService;
	
	@GetMapping("/listeCommunes")
	public String listCommunes ( Model model) 
	{
		try
		{
			List<Commune> communes =  (List<Commune>) communeService.findAll();
			model.addAttribute("communes", communes);
			model.addAttribute("view_path", "listeCommunes");
			model.addAttribute("verticalMenu", "decoupageAdministratif/verticalMenu/defaultMenu");  
			model.addAttribute("breadCrumb", "decoupageAdministratif/breadcrumb/defaultBreadcrumb");
		}
		catch(Exception e)
		{
			
		}
		return "default_template";
	}
	
	@GetMapping("/addCommunes")
	public String  addCommunes( Model model) 
	{
		
		return "commune/addCommunes";
		
	}
	
	@PostMapping("/addCommunes")
    public String addCommunesSubmit(@Validated Commune commune,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			Commune C = new Commune();
			C.setCodeCommune(commune.getCodeCommune());
			C.setNomCommune(commune.getNomCommune());
			C.setDepartement(commune.getDepartement());
			C.setLocalites(commune.getLocalites());
			try
			{
				communeService.save(C);
				List<Commune> communes =  (List<Commune>) communeService.findAll();
				model.addAttribute("communes", communes);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<Commune> communes =  (List<Commune>) communeService.findAll();
				model.addAttribute("communes", communes);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "commune/listeCommunes";
        
    }
	
	@GetMapping("/updateCommunes/{codeCommune}")
    public String updateCommunes(@PathVariable("codeCommune") String codeCommune, Model model) 
	{ 
		try
		{
    		Commune commune =   communeService.findByCodeCommune(codeCommune);
    		model.addAttribute("commune", commune);
		}
		catch(Exception e)
		{
			
		}
		return "commune/updateCommunes";
    		
    }
	
	@PostMapping("/updateCommunes/{codeCommune}")
    public String updateCommunesSubmit(@Validated Commune commune,BindingResult bindingResult,@PathVariable("codeCommune") String codeCommune, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				Commune C = communeService.findByCodeCommune(codeCommune);
				C.setCodeCommune(commune.getCodeCommune());
				C.setNomCommune(commune.getNomCommune());
				C.setDepartement(commune.getDepartement());
				C.setLocalites(commune.getLocalites());
				communeService.save(C);
				List<Commune> communes =  (List<Commune>) communeService.findAll();
				model.addAttribute("communes", communes);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<Commune> communes =  (List<Commune>) communeService.findAll();
			model.addAttribute("communes", communes);
    	}
		
    	return "commune/listeCommunes";
        
    }
	
	@GetMapping("/deleteCommunes/{codeCommune}")
	public String deleteCommunes(@PathVariable("codeCommune") String codeCommune, Model model) 
	{ 
    	model.addAttribute("codeCommune", codeCommune);	
    	return "commune/deleteCommunes";
	    		
	}
	    
	@PostMapping("/deleteCommunes/{codeCommune}")
	public String deleteCommunesSubmit(@Validated BindingResult bindingResult,@PathVariable("codeCommune") String codeCommune, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			Commune C = communeService.findByCodeCommune(codeCommune);
    			communeService.delete(C);
    			List<Commune> communes =  (List<Commune>) communeService.findAll();
    			model.addAttribute("communes", communes);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		Commune C = communeService.findByCodeCommune(codeCommune);
			communeService.delete(C);
			List<Commune> communes =  (List<Commune>) communeService.findAll();
			model.addAttribute("communes", communes);
    	
    	}
    	return "commune/listeCommunes";
        
    }
}
