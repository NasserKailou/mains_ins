package com.atacorp.SISEAN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;

//indiquer qu'il s'agit d'une application spring boot
@SpringBootApplication
//activer la planification des tâches
@EnableScheduling
//activer la gestion des transaction
@EnableTransactionManagement
//définir la base des packages pour que spring boot scan toutes les entités qui s'y trouvent
@EntityScan(basePackages = {"com.atacorp.SISEAN"})
public class SiseanApplication implements WebMvcConfigurer {

	//fonction/méthode point d'entrée de l'application
	public static void main(String[] args) {
		SpringApplication.run(SiseanApplication.class, args);
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		//définir le prefixe du nom des fichiers contenant le lexique de l'application
		messageSource.setBasename("messages");
		//définir l'encodage par défaut
		//messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	// prise en charge de l'internationalisation : définir la langue par defaut
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.FRENCH);
        return slr;
    }
 
	//definir un intercepteur pour le paramètre langue (internationalisation) => exemple : /Region?lang=fr
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
   
 
    //ajout des intercepteurs
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//intercepteur du paramètre langue
        registry.addInterceptor(localeChangeInterceptor());
        //intercepteur pour les requêtes http => gestion des logs (on va esclure le dossier asset pour les liens css et js)
        registry.addInterceptor(new SiseanLogInterceptor()).excludePathPatterns("/assets/**");
        
    }

}
