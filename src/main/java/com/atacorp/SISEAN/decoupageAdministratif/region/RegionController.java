package com.atacorp.SISEAN.decoupageAdministratif.region;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.atacorp.SISEAN.Template;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
//import com.atacorp.SISEAN.utils.ExcelHelper;

@Controller
//@RequestMapping("Regions")
public class RegionController {

	/*@Autowired
	RegionExcelService regionExcelService;*/
	
	@Autowired
	private RegionRepository regionService;
	
	@GetMapping("/listeRegions")
	public String listRegions ( Model model) 
	{
		try
		{
			List<Region> regions =  (List<Region>) regionService.findAll();
			model.addAttribute("regions", regions);
			model.addAttribute("view_path", "listeCommunes");
			model.addAttribute("verticalMenu", "verticalMenu");  
			model.addAttribute("breadCrumb", "breadCrumb");
			
			
			
		}
		catch(Exception e)
		{
			
		}
		return "region/listeRegions";
	}
	
	//@PreAuthorize("hasAuthority('Ajout Région') or hasRole('ROLE_admin')")
	@GetMapping("/addRegions")
	public String  addRegions(RegionForm regionForm, Model model) 
	{
		try
		{
			List<Region> regions =  (List<Region>) regionService.findAll();
			model.addAttribute("regions", regions);
			model.addAttribute("view_path", "decoupageAdministratif/form/region");
			model.addAttribute("horizontalMenu", "decoupageAdministratif/horizontalMenu/defaultMenu");  
			model.addAttribute("breadCrumb", "decoupageAdministratif/breadcrumb/defaultBreadcrumb");
		}
		catch(Exception e)
		{
			
		}
		return Template.defaultTemplate;
		
		
		
	}
	
	@PostMapping("/addRegions")
    public String addRegionsSubmit(@Validated RegionForm regionForm,BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) 
    	{
			
			try
			{
				Region R = new Region();
				R.setCodeRegion(regionForm.getCodeRegion());
				R.setNomRegion(regionForm.getNomRegion());
				regionService.save(R);

				List<Region> regions =  (List<Region>) regionService.findAll();
				model.addAttribute("regions", regions);
				model.addAttribute("operationStatus", "operationStatus/success");
				model.addAttribute("view_path", "decoupageAdministratif/form/region");
				model.addAttribute("horizontalMenu", "decoupageAdministratif/horizontalMenu/defaultMenu");  
				model.addAttribute("breadCrumb", "decoupageAdministratif/breadcrumb/defaultBreadcrumb");
				
			}
			catch(Exception e)
			{
				List<Region> regions =  (List<Region>) regionService.findAll();
				model.addAttribute("regions", regions);
				model.addAttribute("operationStatus", "operationStatus/unsuccess");
				model.addAttribute("view_path", "decoupageAdministratif/form/region");
				model.addAttribute("horizontalMenu", "decoupageAdministratif/horizontalMenu/defaultMenu");  
				model.addAttribute("breadCrumb", "decoupageAdministratif/breadcrumb/defaultBreadcrumb");
				
			}
			
    	}
    	else
    	{
    		try
			{
    			
				
				
				List<Region> regions =  (List<Region>) regionService.findAll();
				model.addAttribute("regions", regions);
				model.addAttribute("view_path", "decoupageAdministratif/form/region");
				model.addAttribute("horizontalMenu", "decoupageAdministratif/horizontalMenu/defaultMenu");  
				model.addAttribute("breadCrumb", "decoupageAdministratif/breadcrumb/defaultBreadcrumb");
			}
			catch(Exception e)
			{
				
			}
    	}
		
    	return "default_template";
        
    }
	
	@GetMapping("/updateRegions/{codeRegion}")
    public String updateRegions(@PathVariable("codeRegion") String codeRegion,RegionForm regionForm, Model model) 
	{ 
		try
		{
    		Region region =   regionService.findByCodeRegion(codeRegion);
    		model.addAttribute("region", region);
    		
    		List<Region> regions =  (List<Region>) regionService.findAll();
			model.addAttribute("regions", regions);
			model.addAttribute("view_path", "decoupageAdministratif/form/region");
			model.addAttribute("horizontalMenu", "decoupageAdministratif/horizontalMenu/defaultMenu");  
			model.addAttribute("breadCrumb", "decoupageAdministratif/breadcrumb/defaultBreadcrumb");
		}
		catch(Exception e)
		{
			
		}
		return "region/updateRegions";
    		
    }
	
	@PostMapping("/updateRegions/{codeRegion}")
    public String updateRegionsSubmit(@Validated Region region,BindingResult bindingResult,@PathVariable("codeRegion") String codeRegion, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
			try
			{
				Region R = regionService.findByCodeRegion(codeRegion);
				R.setCodeRegion(region.getCodeRegion());
				R.setNomRegion(region.getNomRegion());
				R.setDepartements(region.getDepartements());
				regionService.save(R);
				List<Region> regions =  (List<Region>) regionService.findAll();
				model.addAttribute("regions", regions);
				
			}
			catch(Exception e)
			{
				
			}
    	}
    	else
    	{
    		List<Region> regions =  (List<Region>) regionService.findAll();
			model.addAttribute("regions", regions);
    	}
		
    	return "region/listeRegions";
        
    }
	
	@GetMapping("/deleteRegions/{codeRegion}")
	public String deleteRegions(@PathVariable("codeRegion") String codeRegion, Model model) 
	{ 
    	model.addAttribute("codeRegion", codeRegion);	
    	return "region/deleteRegions";
	    		
	}
	    
	@PostMapping("/deleteRegions/{codeRegion}")
	public String deleteRegionsSubmit(@Validated BindingResult bindingResult,@PathVariable("codeRegion") String codeRegion, Model model) 
	{
    	if (!bindingResult.hasErrors()) 
    	{
    		
    		try
    		{
    			Region R = regionService.findByCodeRegion(codeRegion);
    			regionService.delete(R);
    			List<Region> regions =  (List<Region>) regionService.findAll();
    			model.addAttribute("regions", regions);
    		}
    		catch(Exception e)
    		{
    			
    		}
    	}
    	else
    	{
    		Region R = regionService.findByCodeRegion(codeRegion);
			regionService.delete(R);
			List<Region> regions =  (List<Region>) regionService.findAll();
			model.addAttribute("regions", regions);
    	
    	}
    	return "region/listeRegions";
        
    }
	
	/*@PostMapping("/uploadRegions")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		if (TYPE.equals(file.getContentType())) {
			try {
				regionExcelService.importData(file);

		        //message = "Uploaded the file successfully: " + file.getOriginalFilename();
		        return null;
		      } catch (Exception e) {
		        
		        return null;
		      }
		    }

	    //message = "Please upload an excel file!";
	    return null;
	    
	  } 
	@GetMapping("/downloadRegions")
	  public ResponseEntity<Resource> getFile() {
	    String filename = "regions.xlsx";
	    InputStreamResource file = new InputStreamResource(regionExcelService.exportData());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	  }*/
	
	
}
