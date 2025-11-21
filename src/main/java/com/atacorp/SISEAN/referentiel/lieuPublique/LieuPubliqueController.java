package com.atacorp.SISEAN.referentiel.lieuPublique;

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
@RequestMapping("LieuPubliques")
public class LieuPubliqueController {

	@Autowired
	private LieuPubliqueRepository lieuPubliqueService;
	
	@GetMapping("/listLieuPubliques")
	public String listLieuPubliques ( Model model) 
	{
		try
		{
			List<LieuPublique> lieuPubliques =  (List<LieuPublique>) lieuPubliqueService.findAll();
			model.addAttribute("lieuPubliques", lieuPubliques);
		}
		catch(Exception e)
		{
			
		}
		return "lieuPublique/listeLieuPubliques";
	}
	
	@GetMapping("/addLieuPubliques")
	public String  addLieuPubliques( Model model) 
	{
		
		return "lieuPublique/addLieuPubliques";
		
	}
	
	@PostMapping("/addLieuPubliques")
    public String addLieuPubliquesSubmit(@Validated LieuPublique lieuPublique,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			LieuPublique LP = new LieuPublique();
			LP.setDenomination(lieuPublique.getDenomination());
			LP.setLatitude(lieuPublique.getLatitude());
			LP.setLongitude(lieuPublique.getLongitude());
			LP.setLocalite(lieuPublique.getLocalite());
			LP.setTypeLieuPublique(lieuPublique.getTypeLieuPublique());
			try
			{
				lieuPubliqueService.save(LP);
				List<LieuPublique> lieuPubliques =  (List<LieuPublique>) lieuPubliqueService.findAll();
				model.addAttribute("lieuPubliques", lieuPubliques);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<LieuPublique> lieuPubliques =  (List<LieuPublique>) lieuPubliqueService.findAll();
				model.addAttribute("lieuPubliques", lieuPubliques);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "lieuPublique/listeLieuPubliques";
        
    }
	
	@GetMapping("/updateLieuPubliques/{NILP}")
    public String updateLieuPubliques(@PathVariable("NILP") String NILP, Model model) 
	{ 
		try
		{
    		LieuPublique lieuPublique =   lieuPubliqueService.findByNILP(NILP);
    		model.addAttribute("lieuPublique", lieuPublique);
		}
		catch(Exception e)
		{
			
		}
		return "lieuPublique/updateLieuPubliques";
    		
    }
	
	@PostMapping("/updateLieuPubliques/{NILP}")
    public String updateLieuPubliquesSubmit(@Validated LieuPublique lieuPublique,BindingResult bindingResult,@PathVariable("NILP") String NILP, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				LieuPublique LP = lieuPubliqueService.findByNILP(NILP);
				LP.setDenomination(lieuPublique.getDenomination());
				LP.setLatitude(lieuPublique.getLatitude());
				LP.setLongitude(lieuPublique.getLongitude());
				LP.setLocalite(lieuPublique.getLocalite());
				LP.setTypeLieuPublique(lieuPublique.getTypeLieuPublique());
				lieuPubliqueService.save(LP);
				List<LieuPublique> lieuPubliques =  (List<LieuPublique>) lieuPubliqueService.findAll();
				model.addAttribute("lieuPubliques", lieuPubliques);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<LieuPublique> lieuPubliques =  (List<LieuPublique>) lieuPubliqueService.findAll();
			model.addAttribute("lieuPubliques", lieuPubliques);
    	}
		
    	return "lieuPublique/listeLieuPubliques";
        
    }
	
	@GetMapping("/deleteLieuPubliques/{codeLieuPublique}")
	public String deleteLieuPubliques(@PathVariable("codeLieuPublique") String codeLieuPublique, Model model) 
	{ 
    	model.addAttribute("codeLieuPublique", codeLieuPublique);	
    	return "lieuPublique/deleteLieuPubliques";
	    		
	}
	    
	@PostMapping("/deleteLieuPubliques/{NILP}")
	public String deleteLieuPubliquesSubmit(@Validated BindingResult bindingResult,@PathVariable("NILP") String NILP, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			LieuPublique LP = lieuPubliqueService.findByNILP(NILP);
    			lieuPubliqueService.delete(LP);
    			List<LieuPublique> lieuPubliques =  (List<LieuPublique>) lieuPubliqueService.findAll();
    			model.addAttribute("lieuPubliques", lieuPubliques);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		LieuPublique LP = lieuPubliqueService.findByNILP(NILP);
			lieuPubliqueService.delete(LP);
			List<LieuPublique> lieuPubliques =  (List<LieuPublique>) lieuPubliqueService.findAll();
			model.addAttribute("lieuPubliques", lieuPubliques);
    	
    	}
    	return "lieuPublique/listeLieuPubliques";
        
    }
}


