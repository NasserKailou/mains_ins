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
@RequestMapping("FormationSanitaires")
public class FormationSanitaireController {

	@Autowired
	private FormationSanitaireRepository formationSanitaireService;
	
	@GetMapping("/listFormationSanitaires")
	public String listFormationSanitaires ( Model model) 
	{
		try
		{
			List<FormationSanitaire> formationSanitaires =  (List<FormationSanitaire>) formationSanitaireService.findAll();
			model.addAttribute("formationSanitaires", formationSanitaires);
		}
		catch(Exception e)
		{
			
		}
		return "formationSanitaire/listeFormationSanitaires";
	}
	
	@GetMapping("/addFormationSanitaires")
	public String  addFormationSanitaires( Model model) 
	{
		
		return "formationSanitaire/addFormationSanitaires";
		
	}
	
	@PostMapping("/addFormationSanitaires")
    public String addFormationSanitairesSubmit(@Validated FormationSanitaire formationSanitaire,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			FormationSanitaire FS = new FormationSanitaire();
			FS.setDenomination(formationSanitaire.getDenomination());
			FS.setAnneeCreation(formationSanitaire.getAnneeCreation());
			FS.setLatitude(formationSanitaire.getLatitude());
			FS.setLongitude(formationSanitaire.getLongitude());
			FS.setLocalite(formationSanitaire.getLocalite());
			FS.setTypeFormationSanitaire(formationSanitaire.getTypeFormationSanitaire());
			try
			{
				formationSanitaireService.save(FS);
				List<FormationSanitaire> formationSanitaires =  (List<FormationSanitaire>) formationSanitaireService.findAll();
				model.addAttribute("formationSanitaires", formationSanitaires);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<FormationSanitaire> formationSanitaires =  (List<FormationSanitaire>) formationSanitaireService.findAll();
				model.addAttribute("formationSanitaires", formationSanitaires);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "formationSanitaire/listeFormationSanitaires";
        
    }
	
	@GetMapping("/updateFormationSanitaires/{NIFS}")
    public String updateFormationSanitaires(@PathVariable("NIFS") String NIFS, Model model) 
	{ 
		try
		{
    		FormationSanitaire formationSanitaire =   formationSanitaireService.findByNIFS(NIFS);
    		model.addAttribute("formationSanitaire", formationSanitaire);
		}
		catch(Exception e)
		{
			
		}
		return "formationSanitaire/updateFormationSanitaires";
    		
    }
	
	@PostMapping("/updateFormationSanitaires/{NIFS}")
    public String updateFormationSanitairesSubmit(@Validated FormationSanitaire formationSanitaire,BindingResult bindingResult,@PathVariable("NIFS") String NIFS, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				FormationSanitaire FS = formationSanitaireService.findByNIFS(NIFS);
				FS.setDenomination(formationSanitaire.getDenomination());
				FS.setAnneeCreation(formationSanitaire.getAnneeCreation());
				FS.setLatitude(formationSanitaire.getLatitude());
				FS.setLongitude(formationSanitaire.getLongitude());
				FS.setLocalite(formationSanitaire.getLocalite());
				FS.setTypeFormationSanitaire(formationSanitaire.getTypeFormationSanitaire());
				formationSanitaireService.save(FS);
				List<FormationSanitaire> formationSanitaires =  (List<FormationSanitaire>) formationSanitaireService.findAll();
				model.addAttribute("formationSanitaires", formationSanitaires);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<FormationSanitaire> formationSanitaires =  (List<FormationSanitaire>) formationSanitaireService.findAll();
			model.addAttribute("formationSanitaires", formationSanitaires);
    	}
		
    	return "formationSanitaire/listeFormationSanitaires";
        
    }
	
	@GetMapping("/deleteFormationSanitaires/{codeFormationSanitaire}")
	public String deleteFormationSanitaires(@PathVariable("codeFormationSanitaire") String codeFormationSanitaire, Model model) 
	{ 
    	model.addAttribute("codeFormationSanitaire", codeFormationSanitaire);	
    	return "formationSanitaire/deleteFormationSanitaires";
	    		
	}
	    
	@PostMapping("/deleteFormationSanitaires/{NIFS}")
	public String deleteFormationSanitairesSubmit(@Validated BindingResult bindingResult,@PathVariable("NIFS") String NIFS, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			FormationSanitaire FS = formationSanitaireService.findByNIFS(NIFS);
    			formationSanitaireService.delete(FS);
    			List<FormationSanitaire> formationSanitaires =  (List<FormationSanitaire>) formationSanitaireService.findAll();
    			model.addAttribute("formationSanitaires", formationSanitaires);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		FormationSanitaire FS = formationSanitaireService.findByNIFS(NIFS);
			formationSanitaireService.delete(FS);
			List<FormationSanitaire> formationSanitaires =  (List<FormationSanitaire>) formationSanitaireService.findAll();
			model.addAttribute("formationSanitaires", formationSanitaires);
    	
    	}
    	return "formationSanitaire/listeFormationSanitaires";
        
    }
}

