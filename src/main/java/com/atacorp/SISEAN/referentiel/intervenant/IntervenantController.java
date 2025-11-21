package com.atacorp.SISEAN.referentiel.intervenant;

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
@RequestMapping("Intervenants")
public class IntervenantController {

	@Autowired
	private IntervenantRepository intervenantService;
	
	@GetMapping("/listIntervenants")
	public String listIntervenants ( Model model) 
	{
		try
		{
			List<Intervenant> intervenants =  (List<Intervenant>) intervenantService.findAll();
			model.addAttribute("intervenants", intervenants);
		}
		catch(Exception e)
		{
			
		}
		return "intervenant/listeIntervenants";
	}
	
	@GetMapping("/addIntervenants")
	public String  addIntervenants( Model model) 
	{
		
		return "intervenant/addIntervenants";
		
	}
	
	@PostMapping("/addIntervenants")
    public String addIntervenantsSubmit(@Validated Intervenant intervenant,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			Intervenant I = new Intervenant();
			I.setIdIntervenant(intervenant.getIdIntervenant());
			I.setDenomination(intervenant.getDenomination());
			I.setTypeIntervenant(intervenant.getTypeIntervenant());
			try
			{
				intervenantService.save(I);
				List<Intervenant> intervenants =  (List<Intervenant>) intervenantService.findAll();
				model.addAttribute("intervenants", intervenants);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<Intervenant> intervenants =  (List<Intervenant>) intervenantService.findAll();
				model.addAttribute("intervenants", intervenants);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "intervenant/listeIntervenants";
        
    }
	
	@GetMapping("/updateIntervenants/{idIntervenant}")
    public String updateIntervenants(@PathVariable("idIntervenant") Integer idIntervenant, Model model) 
	{ 
		try
		{
    		Intervenant intervenant =   intervenantService.findByIdIntervenant(idIntervenant);
    		model.addAttribute("intervenant", intervenant);
		}
		catch(Exception e)
		{
			
		}
		return "intervenant/updateIntervenants";
    		
    }
	
	@PostMapping("/updateIntervenants/{idIntervenant}")
    public String updateIntervenantsSubmit(@Validated Intervenant intervenant,BindingResult bindingResult,@PathVariable("idIntervenant") Integer idIntervenant, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				Intervenant I = intervenantService.findByIdIntervenant(idIntervenant);
				I.setIdIntervenant(intervenant.getIdIntervenant());
				I.setDenomination(intervenant.getDenomination());
				I.setTypeIntervenant(intervenant.getTypeIntervenant());
				intervenantService.save(I);
				List<Intervenant> intervenants =  (List<Intervenant>) intervenantService.findAll();
				model.addAttribute("intervenants", intervenants);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<Intervenant> intervenants =  (List<Intervenant>) intervenantService.findAll();
			model.addAttribute("intervenants", intervenants);
    	}
		
    	return "intervenant/listeIntervenants";
        
    }
	
	@GetMapping("/deleteIntervenants/{codeIntervenant}")
	public String deleteIntervenants(@PathVariable("codeIntervenant") String codeIntervenant, Model model) 
	{ 
    	model.addAttribute("codeIntervenant", codeIntervenant);	
    	return "intervenant/deleteIntervenants";
	    		
	}
	    
	@PostMapping("/deleteIntervenants/{idIntervenant}")
	public String deleteIntervenantsSubmit(@Validated BindingResult bindingResult,@PathVariable("idIntervenant") Integer idIntervenant, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			Intervenant I = intervenantService.findByIdIntervenant(idIntervenant);
    			intervenantService.delete(I);
    			List<Intervenant> intervenants =  (List<Intervenant>) intervenantService.findAll();
    			model.addAttribute("intervenants", intervenants);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		Intervenant I = intervenantService.findByIdIntervenant(idIntervenant);
			intervenantService.delete(I);
			List<Intervenant> intervenants =  (List<Intervenant>) intervenantService.findAll();
			model.addAttribute("intervenants", intervenants);
    	
    	}
    	return "intervenant/listeIntervenants";
        
    }
}
