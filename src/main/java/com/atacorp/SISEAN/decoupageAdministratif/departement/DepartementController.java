package com.atacorp.SISEAN.decoupageAdministratif.departement;

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
@RequestMapping("Departements")
public class DepartementController {

	@Autowired
	private DepartementRepository departementService;
	
	@GetMapping("/listDepartements")
	public String listDepartements ( Model model) 
	{
		try
		{
			List<Departement> departements =  (List<Departement>) departementService.findAll();
			model.addAttribute("departements", departements);
		}
		catch(Exception e)
		{
			
		}
		return "departement/listeDepartements";
	}
	
	@GetMapping("/addDepartements")
	public String  addDepartements( Model model) 
	{
		
		return "departement/addDepartements";
		
	}
	
	@PostMapping("/addDepartements")
    public String addDepartementsSubmit(@Validated Departement departement,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			Departement D = new Departement();
			D.setCodeDepartement(departement.getCodeDepartement());
			D.setNomDepartement(departement.getNomDepartement());
			D.setRegion(departement.getRegion());
			D.setCommunes(departement.getCommunes());
			try
			{
				departementService.save(D);
				List<Departement> departements =  (List<Departement>) departementService.findAll();
				model.addAttribute("departements", departements);
				
			}
			catch(Exception e)
			{
				
			}
			
    	}
    	else
    	{
    		try
			{
    			List<Departement> departements =  (List<Departement>) departementService.findAll();
				model.addAttribute("departements", departements);
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "departement/listeDepartements";
        
    }
	
	@GetMapping("/updateDepartements/{codeDepartement}")
    public String updateDepartements(@PathVariable("codeDepartement") String codeDepartement, Model model) 
	{ 
		try
		{
    		Departement departement =   departementService.findByCodeDepartement(codeDepartement);
    		model.addAttribute("departement", departement);
		}
		catch(Exception e)
		{
			
		}
		return "departement/updateDepartements";
    		
    }
	
	@PostMapping("/updateDepartements/{codeDepartement}")
    public String updateDepartementsSubmit(@Validated Departement departement,BindingResult bindingResult,@PathVariable("codeDepartement") String codeDepartement, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				Departement D = departementService.findByCodeDepartement(codeDepartement);
				D.setCodeDepartement(departement.getCodeDepartement());
				D.setNomDepartement(departement.getNomDepartement());
				D.setRegion(departement.getRegion());
				D.setCommunes(departement.getCommunes());
				departementService.save(D);
				List<Departement> departements =  (List<Departement>) departementService.findAll();
				model.addAttribute("departements", departements);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<Departement> departements =  (List<Departement>) departementService.findAll();
			model.addAttribute("departements", departements);
    	}
		
    	return "departement/listeDepartements";
        
    }
	
	@GetMapping("/deleteDepartements/{codeDepartement}")
	public String deleteDepartements(@PathVariable("codeDepartement") String codeDepartement, Model model) 
	{ 
    	model.addAttribute("codeDepartement", codeDepartement);	
    	return "departement/deleteDepartements";
	    		
	}
	    
	@PostMapping("/deleteDepartements/{codeDepartement}")
	public String deleteDepartementsSubmit(@Validated BindingResult bindingResult,@PathVariable("codeDepartement") String codeDepartement, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			Departement D = departementService.findByCodeDepartement(codeDepartement);
    			departementService.delete(D);
    			List<Departement> departements =  (List<Departement>) departementService.findAll();
    			model.addAttribute("departements", departements);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		Departement D = departementService.findByCodeDepartement(codeDepartement);
			departementService.delete(D);
			List<Departement> departements =  (List<Departement>) departementService.findAll();
			model.addAttribute("departements", departements);
    	
    	}
    	return "departement/listeDepartements";
        
    }
}
