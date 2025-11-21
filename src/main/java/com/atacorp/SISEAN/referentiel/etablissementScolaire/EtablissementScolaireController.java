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
@RequestMapping("EtablissementScolaires")
public class EtablissementScolaireController {

	@Autowired
	private EtablissementScolaireRepository etablissementScolaireService;
	
	@GetMapping("/listEtablissementScolaires")
	public String listEtablissementScolaires ( Model model) 
	{
		try
		{
			List<EtablissementScolaire> etablissementScolaires =  (List<EtablissementScolaire>) etablissementScolaireService.findAll();
			model.addAttribute("etablissementScolaires", etablissementScolaires);
		}
		catch(Exception e)
		{
			
		}
		return "etablissementScolaire/listeEtablissementScolaires";
	}
	
	@GetMapping("/addEtablissementScolaires")
	public String  addEtablissementScolaires( Model model) 
	{
		
		return "etablissementScolaire/addEtablissementScolaires";
		
	}
	
	@PostMapping("/addEtablissementScolaires")
    public String addEtablissementScolairesSubmit(@Validated EtablissementScolaire etablissementScolaire,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			EtablissementScolaire ES = new EtablissementScolaire();
			ES.setDenomination(etablissementScolaire.getDenomination());
			ES.setAnneeCreation(etablissementScolaire.getAnneeCreation());
			ES.setLatitude(etablissementScolaire.getLatitude());
			ES.setLongitude(etablissementScolaire.getLongitude());
			ES.setLocalite(etablissementScolaire.getLocalite());
			ES.setTypeEtablissementScolaire(etablissementScolaire.getTypeEtablissementScolaire());
			try
			{
				etablissementScolaireService.save(ES);
				List<EtablissementScolaire> etablissementScolaires =  (List<EtablissementScolaire>) etablissementScolaireService.findAll();
				model.addAttribute("etablissementScolaires", etablissementScolaires);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<EtablissementScolaire> etablissementScolaires =  (List<EtablissementScolaire>) etablissementScolaireService.findAll();
				model.addAttribute("etablissementScolaires", etablissementScolaires);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "etablissementScolaire/listeEtablissementScolaires";
        
    }
	
	@GetMapping("/updateEtablissementScolaires/{NIES}")
    public String updateEtablissementScolaires(@PathVariable("NIES") String NIES, Model model) 
	{ 
		try
		{
    		EtablissementScolaire etablissementScolaire =   etablissementScolaireService.findByNIES(NIES);
    		model.addAttribute("etablissementScolaire", etablissementScolaire);
		}
		catch(Exception e)
		{
			
		}
		return "etablissementScolaire/updateEtablissementScolaires";
    		
    }
	
	@PostMapping("/updateEtablissementScolaires/{NIES}")
    public String updateEtablissementScolairesSubmit(@Validated EtablissementScolaire etablissementScolaire,BindingResult bindingResult,@PathVariable("NIES") String NIES, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				EtablissementScolaire ES = etablissementScolaireService.findByNIES(NIES);
				ES.setDenomination(etablissementScolaire.getDenomination());
				ES.setAnneeCreation(etablissementScolaire.getAnneeCreation());
				ES.setLatitude(etablissementScolaire.getLatitude());
				ES.setLongitude(etablissementScolaire.getLongitude());
				ES.setLocalite(etablissementScolaire.getLocalite());
				ES.setTypeEtablissementScolaire(etablissementScolaire.getTypeEtablissementScolaire());
				etablissementScolaireService.save(ES);
				List<EtablissementScolaire> etablissementScolaires =  (List<EtablissementScolaire>) etablissementScolaireService.findAll();
				model.addAttribute("etablissementScolaires", etablissementScolaires);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<EtablissementScolaire> etablissementScolaires =  (List<EtablissementScolaire>) etablissementScolaireService.findAll();
			model.addAttribute("etablissementScolaires", etablissementScolaires);
    	}
		
    	return "etablissementScolaire/listeEtablissementScolaires";
        
    }
	
	@GetMapping("/deleteEtablissementScolaires/{codeEtablissementScolaire}")
	public String deleteEtablissementScolaires(@PathVariable("codeEtablissementScolaire") String codeEtablissementScolaire, Model model) 
	{ 
    	model.addAttribute("codeEtablissementScolaire", codeEtablissementScolaire);	
    	return "etablissementScolaire/deleteEtablissementScolaires";
	    		
	}
	    
	@PostMapping("/deleteEtablissementScolaires/{NIES}")
	public String deleteEtablissementScolairesSubmit(@Validated BindingResult bindingResult,@PathVariable("NIES") String NIES, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			EtablissementScolaire ES = etablissementScolaireService.findByNIES(NIES);
    			etablissementScolaireService.delete(ES);
    			List<EtablissementScolaire> etablissementScolaires =  (List<EtablissementScolaire>) etablissementScolaireService.findAll();
    			model.addAttribute("etablissementScolaires", etablissementScolaires);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		EtablissementScolaire ES = etablissementScolaireService.findByNIES(NIES);
			etablissementScolaireService.delete(ES);
			List<EtablissementScolaire> etablissementScolaires =  (List<EtablissementScolaire>) etablissementScolaireService.findAll();
			model.addAttribute("etablissementScolaires", etablissementScolaires);
    	
    	}
    	return "etablissementScolaire/listeEtablissementScolaires";
        
    }
}

