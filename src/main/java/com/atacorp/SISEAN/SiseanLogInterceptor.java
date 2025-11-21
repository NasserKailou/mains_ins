package com.atacorp.SISEAN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//Intercepteur des requête http
public class SiseanLogInterceptor implements HandlerInterceptor
{
	//Avant l'exécution de la requête http
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
		/*
		 	Traiement à faire
		 	
		 	System.out.println("preHandle : "+request.getRequestURL());
		 	if(request.getSession().getAttribute("login") == "abass") {
	    		response.sendRedirect("/");
	    		return false;
	    	}
		 */

        return true;
    }

	//Après l'exécution de la requête http
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
    	
    }

    //une fois que le traitement de la requête est complet
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
    {
    	
    }
}
