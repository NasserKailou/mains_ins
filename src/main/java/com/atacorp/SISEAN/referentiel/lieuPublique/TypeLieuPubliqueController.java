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
@RequestMapping("TypeLieuPubliques")
public class TypeLieuPubliqueController {

	@Autowired
	private TypeLieuPubliqueRepository typeLieuPubliqueService;
	
	@GetMapping("/listTypeLieuPubliques")
	public String listTypeLieuPubliques ( Model model) 
	{
		try
		{
			List<TypeLieuPublique> typeLieuPubliques =  (List<TypeLieuPublique>) typeLieuPubliqueService.findAll();
			model.addAttribute("typeLieuPubliques", typeLieuPubliques);
		}
		catch(Exception e)
		{
			
		}
		return "typeLieuPublique/listeTypeLieuPubliques";
	}
	
	@GetMapping("/addTypeLieuPubliques")
	public String  addTypeLieuPubliques( Model model) 
	{
		
		return "typeLieuPublique/addTypeLieuPubliques";
		
	}
	
	@PostMapping("/addTypeLieuPubliques")
    public String addTypeLieuPubliquesSubmit(@Validated TypeLieuPublique typeLieuPublique,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			TypeLieuPublique TLP = new TypeLieuPublique();
			TLP.setIdTypeLieuPublique(typeLieuPublique.getIdTypeLieuPublique());
			TLP.setLibelleTypeLieuPublique(typeLieuPublique.getLibelleTypeLieuPublique());
			try
			{
				typeLieuPubliqueService.save(TLP);
				List<TypeLieuPublique> typeLieuPubliques =  (List<TypeLieuPublique>) typeLieuPubliqueService.findAll();
				model.addAttribute("typeLieuPubliques", typeLieuPubliques);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<TypeLieuPublique> typeLieuPubliques =  (List<TypeLieuPublique>) typeLieuPubliqueService.findAll();
				model.addAttribute("typeLieuPubliques", typeLieuPubliques);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "typeLieuPublique/listeTypeLieuPubliques";
        
    }
	
	@GetMapping("/updateTypeLieuPubliques/{idTypeLieuPublique}")
    public String updateTypeLieuPubliques(@PathVariable("idTypeLieuPublique") Integer idTypeLieuPublique, Model model) 
	{ 
		try
		{
    		TypeLieuPublique typeLieuPublique =   typeLieuPubliqueService.findByIdTypeLieuPublique(idTypeLieuPublique);
    		model.addAttribute("typeLieuPublique", typeLieuPublique);
		}
		catch(Exception e)
		{
			
		}
		return "typeLieuPublique/updateTypeLieuPubliques";
    		
    }
	
	@PostMapping("/updateTypeLieuPubliques/{idTypeLieuPublique}")
    public String updateTypeLieuPubliquesSubmit(@Validated TypeLieuPublique typeLieuPublique,BindingResult bindingResult,@PathVariable("idTypeLieuPublique") Integer idTypeLieuPublique, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				TypeLieuPublique TLP = typeLieuPubliqueService.findByIdTypeLieuPublique(idTypeLieuPublique);
				TLP.setIdTypeLieuPublique(typeLieuPublique.getIdTypeLieuPublique());
				TLP.setLibelleTypeLieuPublique(typeLieuPublique.getLibelleTypeLieuPublique());
				typeLieuPubliqueService.save(TLP);
				List<TypeLieuPublique> typeLieuPubliques =  (List<TypeLieuPublique>) typeLieuPubliqueService.findAll();
				model.addAttribute("typeLieuPubliques", typeLieuPubliques);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<TypeLieuPublique> typeLieuPubliques =  (List<TypeLieuPublique>) typeLieuPubliqueService.findAll();
			model.addAttribute("typeLieuPubliques", typeLieuPubliques);
    	}
		
    	return "typeLieuPublique/listeTypeLieuPubliques";
        
    }
	
	@GetMapping("/deleteTypeLieuPubliques/{codeTypeLieuPublique}")
	public String deleteTypeLieuPubliques(@PathVariable("codeTypeLieuPublique") String codeTypeLieuPublique, Model model) 
	{ 
    	model.addAttribute("codeTypeLieuPublique", codeTypeLieuPublique);	
    	return "typeLieuPublique/deleteTypeLieuPubliques";
	    		
	}
	    
	@PostMapping("/deleteTypeLieuPubliques/{idTypeLieuPublique}")
	public String deleteTypeLieuPubliquesSubmit(@Validated BindingResult bindingResult,@PathVariable("idTypeLieuPublique") Integer idTypeLieuPublique, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			TypeLieuPublique TLP = typeLieuPubliqueService.findByIdTypeLieuPublique(idTypeLieuPublique);
    			typeLieuPubliqueService.delete(TLP);
    			List<TypeLieuPublique> typeLieuPubliques =  (List<TypeLieuPublique>) typeLieuPubliqueService.findAll();
    			model.addAttribute("typeLieuPubliques", typeLieuPubliques);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		TypeLieuPublique TLP = typeLieuPubliqueService.findByIdTypeLieuPublique(idTypeLieuPublique);
			typeLieuPubliqueService.delete(TLP);
			List<TypeLieuPublique> typeLieuPubliques =  (List<TypeLieuPublique>) typeLieuPubliqueService.findAll();
			model.addAttribute("typeLieuPubliques", typeLieuPubliques);
    	
    	}
    	return "typeLieuPublique/listeTypeLieuPubliques";
        
    }
}
