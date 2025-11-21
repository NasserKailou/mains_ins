package com.atacorp.SISEAN;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

//activer le traitement asynchrone des tâches
@EnableAsync

public class SiseanTaskScheduling {
	
	/*
	 	Planifier l'exécution d'une tâche de façon périodique (chaque 5 seconde => 5000ms) en fixant un temps initial avant la première exécution 
	 	la périodicité correspond au temps separant la fin de la dernière exécution et le début de la prochaine exécution.
	 	la nouvelle tâche ne demarre que si la précedente est terminée
	*/
	@Scheduled(initialDelay=200000,fixedRate=500000)
	public void scheduleFixedRateTaskWithInitialDelay() { 
		 // définir la tâche à exécuter
	}
	
	/*
	 	Planifier l'exécution des tâches de manières asynchrone. Autrement dit la seconde tâche peut commencer sans que
	 	la première tâche ne soit terminée. 
	 	NB : nous pouvons planifier l'exécution périodique en fixant un temps initial avant la première exécution
	 	@Scheduled(initialDelay=1000,fixedRate=5000)
	*/
	@Async
	@Scheduled(fixedRate = 500000)
	public void scheduleFixedRateTaskAsync() throws InterruptedException {
		// définir la tâche à exécuter
	}
	
	/*
	 	Planifier l'exécution d'une tâche de façon périodique (chaque 5 seconde => 5000ms). 
	 	la périodicité correspond au temps separant la fin de la dernière exécution et le début de la prochaine exécution.
	 	la nouvelle tâche ne demarre que si la précedente est terminée
	*/
    @Scheduled(fixedDelay=500000)
    public void scheduleTaskUsingFixedDelay() {
      // définir la tâche à exécuter
    }
    
    
    /*
     	une expression Cron est representée par six champs : seconde, minute, heure, jour du mois, mois, jours de la semaine
     	(*) correspond a n'importe quelle valeur
     	(*)/X  correspond à chaque X
     	(?) correspond à une valeur non spécifique; utile losqu'on veut spécifier quelque chose dans l'un des deux champs 
     	    dans lesquels le caractère est autorisé 
     	    
     	    "0 0 * * * *" = the top of every hour of every day
     	    "* /10 * * * * *" = chaque 10 secondes
     	    "0 0 8-10 * * *" = 8, 9 et 10H de chaque jour
     	    "0 0 8,10 * * *" = 8 et 10H de chaque jour
     	    "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 et 10H de chaque jour
     	    "0 0 9-17 * * MON-FRI" = de 9H à 17H pendant les 5 jours de la semaine (du lundi au vendredi) 
     	    
     	    "@yearly or @annually" = une fois par an  (0 0 0 1 1 *)
     	    "@monthlyé = une fois par mois (0 0 0 1 * *)
     	    "@weekly" = une fois par semaine (0 0 0 * * 0)
     	    "@daily" = une fois par jour (0 0 0 * * *)
     	    "@hourly" = une fois par heur  (0 0 * * * *)
     	    "0 0 0 L * *" = last day of the month at midnight
     	    "0 0 0 L-3 * *" = third-to-last day of the month at midnight
     	    "0 0 0 * * 5L" = last Friday of the month at midnight
     	    "0 0 0 * * THUL" = last Thursday of the month at midnight
     	    "0 0 0 1W * *" = first weekday of the month at midnight
     	    "0 0 0 LW * *" = last weekday of the month at midnight
     	    "0 0 0 ? * 5#2" = the second Friday in the month at midnight
     	    "0 0 0 ? * MON#1" = the first Monday in the month at midnight
     	    
     	    Exemple : Planifier une tâche qui sera exécutée à 1H du matin de chaque jour
     	
    */
    
    @Scheduled(cron = "0 0 1 * * *")
    public void scheduleTaskUsingCronExpression() {
    	// définir la tâche à exécuter : backup par exemple
    }
    
    
}
