package com.atacorp.SISEAN.referentiel.formationSanitaire;

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
@RequestMapping("TypeFormationSanitaires")
public class TypeFormationSanitaireController {

	@Autowired
	private TypeFormationSanitaireRepository typeFormationSanitaireService;
	
	@GetMapping("/listTypeFormationSanitaires")
	public String listTypeFormationSanitaires ( Model model) 
	{
		try
		{
			List<TypeFormationSanitaire> typeFormationSanitaires =  (List<TypeFormationSanitaire>) typeFormationSanitaireService.findAll();
			model.addAttribute("typeFormationSanitaires", typeFormationSanitaires);
		}
		catch(Exception e)
		{
			
		}
		return "typeFormationSanitaire/listeTypeFormationSanitaires";
	}
	
	@GetMapping("/addTypeFormationSanitaires")
	public String  addTypeFormationSanitaires( Model model) 
	{
		
		return "typeFormationSanitaire/addTypeFormationSanitaires";
		
	}
	
	@PostMapping("/addTypeFormationSanitaires")
    public String addTypeFormationSanitairesSubmit(@Validated TypeFormationSanitaire typeFormationSanitaire,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			TypeFormationSanitaire TFS = new TypeFormationSanitaire();
			TFS.setIdTypeFormationSanitaire(typeFormationSanitaire.getIdTypeFormationSanitaire());
			TFS.setLibelleTypeFormationSanitaire(typeFormationSanitaire.getLibelleTypeFormationSanitaire());
			try
			{
				typeFormationSanitaireService.save(TFS);
				List<TypeFormationSanitaire> typeFormationSanitaires =  (List<TypeFormationSanitaire>) typeFormationSanitaireService.findAll();
				model.addAttribute("typeFormationSanitaires", typeFormationSanitaires);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<TypeFormationSanitaire> typeFormationSanitaires =  (List<TypeFormationSanitaire>) typeFormationSanitaireService.findAll();
				model.addAttribute("typeFormationSanitaires", typeFormationSanitaires);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "typeFormationSanitaire/listeTypeFormationSanitaires";
        
    }
	
	@GetMapping("/updateTypeFormationSanitaires/{idTypeFormationSanitaire}")
    public String updateTypeFormationSanitaires(@PathVariable("idTypeFormationSanitaire") Integer idTypeFormationSanitaire, Model model) 
	{ 
		try
		{
    		TypeFormationSanitaire typeFormationSanitaire =   typeFormationSanitaireService.findByIdTypeFormationSanitaire(idTypeFormationSanitaire);
    		model.addAttribute("typeFormationSanitaire", typeFormationSanitaire);
		}
		catch(Exception e)
		{
			
		}
		return "typeFormationSanitaire/updateTypeFormationSanitaires";
    		
    }
	
	@PostMapping("/updateTypeFormationSanitaires/{idTypeFormationSanitaire}")
    public String updateTypeFormationSanitairesSubmit(@Validated TypeFormationSanitaire typeFormationSanitaire,BindingResult bindingResult,@PathVariable("idTypeFormationSanitaire") Integer idTypeFormationSanitaire, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				TypeFormationSanitaire TFS = typeFormationSanitaireService.findByIdTypeFormationSanitaire(idTypeFormationSanitaire);
				TFS.setIdTypeFormationSanitaire(typeFormationSanitaire.getIdTypeFormationSanitaire());
				TFS.setLibelleTypeFormationSanitaire(typeFormationSanitaire.getLibelleTypeFormationSanitaire());
				typeFormationSanitaireService.save(TFS);
				List<TypeFormationSanitaire> typeFormationSanitaires =  (List<TypeFormationSanitaire>) typeFormationSanitaireService.findAll();
				model.addAttribute("typeFormationSanitaires", typeFormationSanitaires);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<TypeFormationSanitaire> typeFormationSanitaires =  (List<TypeFormationSanitaire>) typeFormationSanitaireService.findAll();
			model.addAttribute("typeFormationSanitaires", typeFormationSanitaires);
    	}
		
    	return "typeFormationSanitaire/listeTypeFormationSanitaires";
        
    }
	
	@GetMapping("/deleteTypeFormationSanitaires/{codeTypeFormationSanitaire}")
	public String deleteTypeFormationSanitaires(@PathVariable("codeTypeFormationSanitaire") String codeTypeFormationSanitaire, Model model) 
	{ 
    	model.addAttribute("codeTypeFormationSanitaire", codeTypeFormationSanitaire);	
    	return "typeFormationSanitaire/deleteTypeFormationSanitaires";
	    		
	}
	    
	@PostMapping("/deleteTypeFormationSanitaires/{idTypeFormationSanitaire}")
	public String deleteTypeFormationSanitairesSubmit(@Validated BindingResult bindingResult,@PathVariable("idTypeFormationSanitaire") Integer idTypeFormationSanitaire, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			TypeFormationSanitaire TFS = typeFormationSanitaireService.findByIdTypeFormationSanitaire(idTypeFormationSanitaire);
    			typeFormationSanitaireService.delete(TFS);
    			List<TypeFormationSanitaire> typeFormationSanitaires =  (List<TypeFormationSanitaire>) typeFormationSanitaireService.findAll();
    			model.addAttribute("typeFormationSanitaires", typeFormationSanitaires);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		TypeFormationSanitaire TFS = typeFormationSanitaireService.findByIdTypeFormationSanitaire(idTypeFormationSanitaire);
			typeFormationSanitaireService.delete(TFS);
			List<TypeFormationSanitaire> typeFormationSanitaires =  (List<TypeFormationSanitaire>) typeFormationSanitaireService.findAll();
			model.addAttribute("typeFormationSanitaires", typeFormationSanitaires);
    	
    	}
    	return "typeFormationSanitaire/listeTypeFormationSanitaires";
        
    }
}
