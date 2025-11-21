package com.atacorp.SISEAN.evenement;

/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.support.RequestHandledEvent;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.atacorp.SISEAN.permission.User;
import com.atacorp.SISEAN.permission.UserRepository;

@Component
public class SiseanEventListener {

	@Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    /*@Autowired
	private HttpServletRequest request;
	private HttpSession session;*/
	@EventListener
	public void ApplicationStarted (ApplicationStartedEvent e) {
		//initialiser l'application avec un utilisateur admin s'il n'existe pas encore en base
		if(userRepository.findByLogin("admin") == null) {
			User user = new User();
			user.setLogin("admin");
			user.setMotPasse(bCryptPasswordEncoder.encode("admin"));
			user.setActive(true);
			user.setTokenExpire(false);
	        userRepository.save(user);
		}
		
	}
	
	/*@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	public void handleEvent(RequestHandledEvent e) {
	    System.out.println("Handling event inside a transaction BEFORE COMMIT.");
	}*/
}
