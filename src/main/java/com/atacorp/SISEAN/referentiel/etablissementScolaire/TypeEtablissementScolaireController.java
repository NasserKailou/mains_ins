package com.atacorp.SISEAN.referentiel.etablissementScolaire;

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
@RequestMapping("TypeEtablissementScolaires")
public class TypeEtablissementScolaireController {

	@Autowired
	private TypeEtablissementScolaireRepository typeEtablissementScolaireService;
	
	@GetMapping("/listTypeEtablissementScolaires")
	public String listTypeEtablissementScolaires ( Model model) 
	{
		try
		{
			List<TypeEtablissementScolaire> typeEtablissementScolaires =  (List<TypeEtablissementScolaire>) typeEtablissementScolaireService.findAll();
			model.addAttribute("typeEtablissementScolaires", typeEtablissementScolaires);
		}
		catch(Exception e)
		{
			
		}
		return "typeEtablissementScolaire/listeTypeEtablissementScolaires";
	}
	
	@GetMapping("/addTypeEtablissementScolaires")
	public String  addTypeEtablissementScolaires( Model model) 
	{
		
		return "typeEtablissementScolaire/addTypeEtablissementScolaires";
		
	}
	
	@PostMapping("/addTypeEtablissementScolaires")
    public String addTypeEtablissementScolairesSubmit(@Validated TypeEtablissementScolaire typeEtablissementScolaire,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			TypeEtablissementScolaire TES = new TypeEtablissementScolaire();
			TES.setIdTypeEtablissementScolaire(typeEtablissementScolaire.getIdTypeEtablissementScolaire());
			TES.setLibelleTypeEtablissementScolaire(typeEtablissementScolaire.getLibelleTypeEtablissementScolaire());
			try
			{
				typeEtablissementScolaireService.save(TES);
				List<TypeEtablissementScolaire> typeEtablissementScolaires =  (List<TypeEtablissementScolaire>) typeEtablissementScolaireService.findAll();
				model.addAttribute("typeEtablissementScolaires", typeEtablissementScolaires);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<TypeEtablissementScolaire> typeEtablissementScolaires =  (List<TypeEtablissementScolaire>) typeEtablissementScolaireService.findAll();
				model.addAttribute("typeEtablissementScolaires", typeEtablissementScolaires);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "typeEtablissementScolaire/listeTypeEtablissementScolaires";
        
    }
	
	@GetMapping("/updateTypeEtablissementScolaires/{idTypeEtablissementScolaire}")
    public String updateTypeEtablissementScolaires(@PathVariable("idTypeEtablissementScolaire") Integer idTypeEtablissementScolaire, Model model) 
	{ 
		try
		{
    		TypeEtablissementScolaire typeEtablissementScolaire =   typeEtablissementScolaireService.findByIdTypeEtablissementScolaire(idTypeEtablissementScolaire);
    		model.addAttribute("typeEtablissementScolaire", typeEtablissementScolaire);
		}
		catch(Exception e)
		{
			
		}
		return "typeEtablissementScolaire/updateTypeEtablissementScolaires";
    		
    }
	
	@PostMapping("/updateTypeEtablissementScolaires/{idTypeEtablissementScolaire}")
    public String updateTypeEtablissementScolairesSubmit(@Validated TypeEtablissementScolaire typeEtablissementScolaire,BindingResult bindingResult,@PathVariable("idTypeEtablissementScolaire") Integer idTypeEtablissementScolaire, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				TypeEtablissementScolaire TES = typeEtablissementScolaireService.findByIdTypeEtablissementScolaire(idTypeEtablissementScolaire);
				TES.setIdTypeEtablissementScolaire(typeEtablissementScolaire.getIdTypeEtablissementScolaire());
				TES.setLibelleTypeEtablissementScolaire(typeEtablissementScolaire.getLibelleTypeEtablissementScolaire());
				typeEtablissementScolaireService.save(TES);
				List<TypeEtablissementScolaire> typeEtablissementScolaires =  (List<TypeEtablissementScolaire>) typeEtablissementScolaireService.findAll();
				model.addAttribute("typeEtablissementScolaires", typeEtablissementScolaires);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<TypeEtablissementScolaire> typeEtablissementScolaires =  (List<TypeEtablissementScolaire>) typeEtablissementScolaireService.findAll();
			model.addAttribute("typeEtablissementScolaires", typeEtablissementScolaires);
    	}
		
    	return "typeEtablissementScolaire/listeTypeEtablissementScolaires";
        
    }
	
	@GetMapping("/deleteTypeEtablissementScolaires/{codeTypeEtablissementScolaire}")
	public String deleteTypeEtablissementScolaires(@PathVariable("codeTypeEtablissementScolaire") String codeTypeEtablissementScolaire, Model model) 
	{ 
    	model.addAttribute("codeTypeEtablissementScolaire", codeTypeEtablissementScolaire);	
    	return "typeEtablissementScolaire/deleteTypeEtablissementScolaires";
	    		
	}
	    
	@PostMapping("/deleteTypeEtablissementScolaires/{idTypeEtablissementScolaire}")
	public String deleteTypeEtablissementScolairesSubmit(@Validated BindingResult bindingResult,@PathVariable("idTypeEtablissementScolaire") Integer idTypeEtablissementScolaire, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			TypeEtablissementScolaire TES = typeEtablissementScolaireService.findByIdTypeEtablissementScolaire(idTypeEtablissementScolaire);
    			typeEtablissementScolaireService.delete(TES);
    			List<TypeEtablissementScolaire> typeEtablissementScolaires =  (List<TypeEtablissementScolaire>) typeEtablissementScolaireService.findAll();
    			model.addAttribute("typeEtablissementScolaires", typeEtablissementScolaires);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		TypeEtablissementScolaire TES = typeEtablissementScolaireService.findByIdTypeEtablissementScolaire(idTypeEtablissementScolaire);
			typeEtablissementScolaireService.delete(TES);
			List<TypeEtablissementScolaire> typeEtablissementScolaires =  (List<TypeEtablissementScolaire>) typeEtablissementScolaireService.findAll();
			model.addAttribute("typeEtablissementScolaires", typeEtablissementScolaires);
    	
    	}
    	return "typeEtablissementScolaire/listeTypeEtablissementScolaires";
        
    }
}
