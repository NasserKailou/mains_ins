package com.atacorp.SISEAN;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//controller par defaut
@Controller
public class SiseanDefaultController {

	//affichage de la page login
	@GetMapping("/login")
	public String Connexion( Model model)
	{
		model.addAttribute("view_path", "connexion");
		return "default_template";
	}
}
