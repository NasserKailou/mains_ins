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
@RequestMapping("TypeIntervenants")
public class TypeIntervenantController {

	@Autowired
	private TypeIntervenantRepository typeIntervenantService;
	
	@GetMapping("/listTypeIntervenants")
	public String listTypeIntervenants ( Model model) 
	{
		try
		{
			List<TypeIntervenant> typeIntervenants =  (List<TypeIntervenant>) typeIntervenantService.findAll();
			model.addAttribute("typeIntervenants", typeIntervenants);
		}
		catch(Exception e)
		{
			
		}
		return "typeIntervenant/listeTypeIntervenants";
	}
	
	@GetMapping("/addTypeIntervenants")
	public String  addTypeIntervenants( Model model) 
	{
		
		return "typeIntervenant/addTypeIntervenants";
		
	}
	
	@PostMapping("/addTypeIntervenants")
    public String addTypeIntervenantsSubmit(@Validated TypeIntervenant typeIntervenant,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			TypeIntervenant TI = new TypeIntervenant();
			TI.setIdTypeIntervenant(typeIntervenant.getIdTypeIntervenant());
			TI.setLibelleTypeIntervenant(typeIntervenant.getLibelleTypeIntervenant());
			try
			{
				typeIntervenantService.save(TI);
				List<TypeIntervenant> typeIntervenants =  (List<TypeIntervenant>) typeIntervenantService.findAll();
				model.addAttribute("typeIntervenants", typeIntervenants);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<TypeIntervenant> typeIntervenants =  (List<TypeIntervenant>) typeIntervenantService.findAll();
				model.addAttribute("typeIntervenants", typeIntervenants);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "typeIntervenant/listeTypeIntervenants";
        
    }
	
	@GetMapping("/updateTypeIntervenants/{idTypeIntervenant}")
    public String updateTypeIntervenants(@PathVariable("idTypeIntervenant") Integer idTypeIntervenant, Model model) 
	{ 
		try
		{
    		TypeIntervenant typeIntervenant =   typeIntervenantService.findByIdTypeIntervenant(idTypeIntervenant);
    		model.addAttribute("typeIntervenant", typeIntervenant);
		}
		catch(Exception e)
		{
			
		}
		return "typeIntervenant/updateTypeIntervenants";
    		
    }
	
	@PostMapping("/updateTypeIntervenants/{idTypeIntervenant}")
    public String updateTypeIntervenantsSubmit(@Validated TypeIntervenant typeIntervenant,BindingResult bindingResult,@PathVariable("idTypeIntervenant") Integer idTypeIntervenant, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				TypeIntervenant TI = typeIntervenantService.findByIdTypeIntervenant(idTypeIntervenant);
				TI.setIdTypeIntervenant(typeIntervenant.getIdTypeIntervenant());
				TI.setLibelleTypeIntervenant(typeIntervenant.getLibelleTypeIntervenant());
				typeIntervenantService.save(TI);
				List<TypeIntervenant> typeIntervenants =  (List<TypeIntervenant>) typeIntervenantService.findAll();
				model.addAttribute("typeIntervenants", typeIntervenants);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<TypeIntervenant> typeIntervenants =  (List<TypeIntervenant>) typeIntervenantService.findAll();
			model.addAttribute("typeIntervenants", typeIntervenants);
    	}
		
    	return "typeIntervenant/listeTypeIntervenants";
        
    }
	
	@GetMapping("/deleteTypeIntervenants/{codeTypeIntervenant}")
	public String deleteTypeIntervenants(@PathVariable("codeTypeIntervenant") String codeTypeIntervenant, Model model) 
	{ 
    	model.addAttribute("codeTypeIntervenant", codeTypeIntervenant);	
    	return "typeIntervenant/deleteTypeIntervenants";
	    		
	}
	    
	@PostMapping("/deleteTypeIntervenants/{idTypeIntervenant}")
	public String deleteTypeIntervenantsSubmit(@Validated BindingResult bindingResult,@PathVariable("idTypeIntervenant") Integer idTypeIntervenant, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			TypeIntervenant TI = typeIntervenantService.findByIdTypeIntervenant(idTypeIntervenant);
    			typeIntervenantService.delete(TI);
    			List<TypeIntervenant> typeIntervenants =  (List<TypeIntervenant>) typeIntervenantService.findAll();
    			model.addAttribute("typeIntervenants", typeIntervenants);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		TypeIntervenant TI = typeIntervenantService.findByIdTypeIntervenant(idTypeIntervenant);
			typeIntervenantService.delete(TI);
			List<TypeIntervenant> typeIntervenants =  (List<TypeIntervenant>) typeIntervenantService.findAll();
			model.addAttribute("typeIntervenants", typeIntervenants);
    	
    	}
    	return "typeIntervenant/listeTypeIntervenants";
        
    }
}
