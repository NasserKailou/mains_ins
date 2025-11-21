package com.atacorp.SISEAN.referentiel.recensementINS;

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
@RequestMapping("RecensementINSs")
public class RecensementINSController {

	@Autowired
	private RecensementINSRepository recensementINSService;
	
	@GetMapping("/listRecensementINSs")
	public String listRecensementINSs ( Model model) 
	{
		try
		{
			List<RecensementINS> recensementINSs =  (List<RecensementINS>) recensementINSService.findAll();
			model.addAttribute("recensementINSs", recensementINSs);
		}
		catch(Exception e)
		{
			
		}
		return "recensementINS/listeRecensementINSs";
	}
	
	@GetMapping("/addRecensementINSs")
	public String  addRecensementINSs( Model model) 
	{
		
		return "recensementINS/addRecensementINSs";
		
	}
	
	@PostMapping("/addRecensementINSs")
    public String addRecensementINSsSubmit(@Validated RecensementINS recensementINS,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			RecensementINS R = new RecensementINS();
			R.setIdRecensementINS(recensementINS.getIdRecensementINS());
			R.setAnneeRecensement(recensementINS.getAnneeRecensement());
			R.setPopulationTotale(recensementINS.getPopulationTotale());
			R.setPopulationHomme(recensementINS.getPopulationHomme());
			R.setPopulationFemme(recensementINS.getPopulationFemme());
			R.setTauxAccroissementPopulation(recensementINS.getTauxAccroissementPopulation());
			R.setNombreMenage(recensementINS.getNombreMenage());
			R.setLocalite(recensementINS.getLocalite());
			try
			{
				recensementINSService.save(R);
				List<RecensementINS> recensementINSs =  (List<RecensementINS>) recensementINSService.findAll();
				model.addAttribute("recensementINSs", recensementINSs);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<RecensementINS> recensementINSs =  (List<RecensementINS>) recensementINSService.findAll();
				model.addAttribute("recensementINSs", recensementINSs);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "recensementINS/listeRecensementINSs";
        
    }
	
	@GetMapping("/updateRecensementINSs/{idRecensementINS}")
    public String updateRecensementINSs(@PathVariable("idRecensementINS") Integer idRecensementINS, Model model) 
	{ 
		try
		{
    		RecensementINS recensementINS =   recensementINSService.findByIdRecensementINS(idRecensementINS);
    		model.addAttribute("recensementINS", recensementINS);
		}
		catch(Exception e)
		{
			
		}
		return "recensementINS/updateRecensementINSs";
    		
    }
	
	@PostMapping("/updateRecensementINSs/{idRecensementINS}")
    public String updateRecensementINSsSubmit(@Validated RecensementINS recensementINS,BindingResult bindingResult,@PathVariable("idRecensementINS") Integer idRecensementINS, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				RecensementINS R = recensementINSService.findByIdRecensementINS(idRecensementINS);
				R.setIdRecensementINS(recensementINS.getIdRecensementINS());
				R.setAnneeRecensement(recensementINS.getAnneeRecensement());
				R.setPopulationTotale(recensementINS.getPopulationTotale());
				R.setPopulationHomme(recensementINS.getPopulationHomme());
				R.setPopulationFemme(recensementINS.getPopulationFemme());
				R.setTauxAccroissementPopulation(recensementINS.getTauxAccroissementPopulation());
				R.setNombreMenage(recensementINS.getNombreMenage());
				R.setLocalite(recensementINS.getLocalite());
				recensementINSService.save(R);
				List<RecensementINS> recensementINSs =  (List<RecensementINS>) recensementINSService.findAll();
				model.addAttribute("recensementINSs", recensementINSs);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<RecensementINS> recensementINSs =  (List<RecensementINS>) recensementINSService.findAll();
			model.addAttribute("recensementINSs", recensementINSs);
    	}
		
    	return "recensementINS/listeRecensementINSs";
        
    }
	
	@GetMapping("/deleteRecensementINSs/{codeRecensementINS}")
	public String deleteRecensementINSs(@PathVariable("codeRecensementINS") String codeRecensementINS, Model model) 
	{ 
    	model.addAttribute("codeRecensementINS", codeRecensementINS);	
    	return "recensementINS/deleteRecensementINSs";
	    		
	}
	    
	@PostMapping("/deleteRecensementINSs/{idRecensementINS}")
	public String deleteRecensementINSsSubmit(@Validated BindingResult bindingResult,@PathVariable("idRecensementINS") Integer idRecensementINS, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			RecensementINS R = recensementINSService.findByIdRecensementINS(idRecensementINS);
    			recensementINSService.delete(R);
    			List<RecensementINS> recensementINSs =  (List<RecensementINS>) recensementINSService.findAll();
    			model.addAttribute("recensementINSs", recensementINSs);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		RecensementINS R = recensementINSService.findByIdRecensementINS(idRecensementINS);
			recensementINSService.delete(R);
			List<RecensementINS> recensementINSs =  (List<RecensementINS>) recensementINSService.findAll();
			model.addAttribute("recensementINSs", recensementINSs);
    	
    	}
    	return "recensementINS/listeRecensementINSs";
        
    }
}
