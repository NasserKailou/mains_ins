package com.atacorp.SISEAN;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

//gestionnaire des refus d'accès
public class SiseanAccessDeniedHandler implements AccessDeniedHandler {
	@Override
    public void handle(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,AccessDeniedException e) throws IOException, ServletException {

        /*
         	Traitement à faire lorsqu'un utilisateur tente d'accéder à une page dont l'accès n'est pas autorisé
         	
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) 
	        {
	        	String infos = auth.getName() + httpServletRequest.getRequestURI();
	        }
        */

		//rédirection vers la page accès refusé
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/AccessDenied");

    }
}
