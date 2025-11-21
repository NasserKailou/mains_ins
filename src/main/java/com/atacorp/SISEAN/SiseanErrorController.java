package com.atacorp.SISEAN;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiseanErrorController implements ErrorController {

	//Affichage de la page d'erreur
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request,Model model) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	        //cas d'erreur 404
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            model.addAttribute("view_path", "error/error-404");
	            return "default_template";
	        }
	        //cas d'erreur 500
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	model.addAttribute("view_path", "error/error-500");
	        	 return "default_template";
	        }
	    }
	    model.addAttribute("view_path", "error/error");
	    return "default_template";
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Affichage de la page accès refusé
	@GetMapping("/AccessDenied")
	public String  addCommunes( Model model) 
	{
		model.addAttribute("view_path", "error/error-403");
   	 	return "default_template";
		
	}
}
