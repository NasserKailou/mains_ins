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
@RequestMapping("TypeLocalites")
public class TypeLocaliteController {

	@Autowired
	private TypeLocaliteRepository typeLocaliteService;
	
	@GetMapping("/listTypeLocalites")
	public String listTypeLocalites ( Model model) 
	{
		try
		{
			List<TypeLocalite> typeLocalites =  (List<TypeLocalite>) typeLocaliteService.findAll();
			model.addAttribute("typeLocalites", typeLocalites);
		}
		catch(Exception e)
		{
			
		}
		return "typeLocalite/listeTypeLocalites";
	}
	
	@GetMapping("/addTypeLocalites")
	public String  addTypeLocalites( Model model) 
	{
		
		return "typeLocalite/addTypeLocalites";
		
	}
	
	@PostMapping("/addTypeLocalites")
    public String addTypeLocalitesSubmit(@Validated TypeLocalite typeLocalite,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			TypeLocalite TL = new TypeLocalite();
			TL.setIdTypeLocalite(typeLocalite.getIdTypeLocalite());
			TL.setLibelleTypeLocalite(typeLocalite.getLibelleTypeLocalite());
			try
			{
				typeLocaliteService.save(TL);
				List<TypeLocalite> typeLocalites =  (List<TypeLocalite>) typeLocaliteService.findAll();
				model.addAttribute("typeLocalites", typeLocalites);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<TypeLocalite> typeLocalites =  (List<TypeLocalite>) typeLocaliteService.findAll();
				model.addAttribute("typeLocalites", typeLocalites);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "typeLocalite/listeTypeLocalites";
        
    }
	
	@GetMapping("/updateTypeLocalites/{idTypeLocalite}")
    public String updateTypeLocalites(@PathVariable("idTypeLocalite") Integer idTypeLocalite, Model model) 
	{ 
		try
		{
    		TypeLocalite typeLocalite =   typeLocaliteService.findByIdTypeLocalite(idTypeLocalite);
    		model.addAttribute("typeLocalite", typeLocalite);
		}
		catch(Exception e)
		{
			
		}
		return "typeLocalite/updateTypeLocalites";
    		
    }
	
	@PostMapping("/updateTypeLocalites/{idTypeLocalite}")
    public String updateTypeLocalitesSubmit(@Validated TypeLocalite typeLocalite,BindingResult bindingResult,@PathVariable("idTypeLocalite") Integer idTypeLocalite, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				TypeLocalite TL = typeLocaliteService.findByIdTypeLocalite(idTypeLocalite);
				TL.setIdTypeLocalite(typeLocalite.getIdTypeLocalite());
				TL.setIdTypeLocalite(typeLocalite.getIdTypeLocalite());
				TL.setLibelleTypeLocalite(typeLocalite.getLibelleTypeLocalite());
				typeLocaliteService.save(TL);
				List<TypeLocalite> typeLocalites =  (List<TypeLocalite>) typeLocaliteService.findAll();
				model.addAttribute("typeLocalites", typeLocalites);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<TypeLocalite> typeLocalites =  (List<TypeLocalite>) typeLocaliteService.findAll();
			model.addAttribute("typeLocalites", typeLocalites);
    	}
		
    	return "typeLocalite/listeTypeLocalites";
        
    }
	
	@GetMapping("/deleteTypeLocalites/{idTypeLocalite}")
	public String deleteTypeLocalites(@PathVariable("idTypeLocalite") Integer idTypeLocalite, Model model) 
	{ 
    	model.addAttribute("idTypeLocalite", idTypeLocalite);	
    	return "typeLocalite/deleteTypeLocalites";
	    		
	}
	    
	@PostMapping("/deleteTypeLocalites/{idTypeLocalite}")
	public String deleteTypeLocalitesSubmit(@Validated BindingResult bindingResult,@PathVariable("idTypeLocalite") Integer idTypeLocalite, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			TypeLocalite TL = typeLocaliteService.findByIdTypeLocalite(idTypeLocalite);
    			typeLocaliteService.delete(TL);
    			List<TypeLocalite> typeLocalites =  (List<TypeLocalite>) typeLocaliteService.findAll();
    			model.addAttribute("typeLocalites", typeLocalites);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		TypeLocalite TL = typeLocaliteService.findByIdTypeLocalite(idTypeLocalite);
			typeLocaliteService.delete(TL);
			List<TypeLocalite> typeLocalites =  (List<TypeLocalite>) typeLocaliteService.findAll();
			model.addAttribute("typeLocalites", typeLocalites);
    	
    	}
    	return "typeLocalite/listeTypeLocalites";
        
    }
}
